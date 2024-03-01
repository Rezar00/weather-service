package com.wiseboy.weatherservice.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiseboy.weatherservice.dto.WeatherDTO;
import com.wiseboy.weatherservice.exception.BusinessException;
import com.wiseboy.weatherservice.adapter.model.ErrorResponse;
import com.wiseboy.weatherservice.adapter.model.WeatherStackResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
@RequiredArgsConstructor
public class WeatherStackAdapter {

    private final ObjectMapper mapper;

    @Value(value = "${weatherstack.url}")
    private String weatherStackUrl;

    @Value(value = "${weatherstack.access-key}")
    private String weatherStackAccessKey;

    /**
     * Retrieves the current weather status for the specified city.
     *
     * @param city the name of the city to retrieve the weather status for
     * @return a WeatherDTO object containing the city name and temperature
     * @throws BusinessException if an error occurs while retrieving the weather status
     */
    public WeatherDTO getWeatherStatusByCity(String city) {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            String queryString = String.format("access_key=%s&query=%s", weatherStackAccessKey, city);
            HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create(weatherStackUrl + queryString))
                    .build();
            HttpResponse<String> res = httpClient.send(req, HttpResponse.BodyHandlers.ofString());
            if (res.body().contains("success")) {
                ErrorResponse errorResponse = mapper.readValue(res.body(), ErrorResponse.class);
                throw new BusinessException(errorResponse.getError().getInfo(),
                        Integer.parseInt(errorResponse.getError().getCode()));
            }
            WeatherStackResponse weatherStackResponse = mapper.readValue(res.body(), WeatherStackResponse.class);
            return WeatherDTO.builder()
                    .cityName(city)
                    .temperature(weatherStackResponse.getCurrent().getTemperature())
                    .build();
        } catch (InterruptedException | IOException ex) {
            throw new BusinessException("Cannot call weather api", HttpStatus.UNPROCESSABLE_ENTITY.value());
        }
    }
}
