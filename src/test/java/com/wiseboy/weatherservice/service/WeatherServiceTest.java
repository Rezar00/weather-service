package com.wiseboy.weatherservice.service;

import com.wiseboy.weatherservice.dto.WeatherDTO;
import com.wiseboy.weatherservice.entity.Weather;
import com.wiseboy.weatherservice.exception.BusinessException;
import com.wiseboy.weatherservice.mapper.WeatherMapper;
import com.wiseboy.weatherservice.repository.WeatherRepository;
import com.wiseboy.weatherservice.service.impl.WeatherServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

class WeatherServiceTest {

    @InjectMocks
    private WeatherServiceImpl weatherService;

    @Mock
    private WeatherRepository weatherRepository;

    @Mock
    private WeatherMapper weatherMapper;

    @BeforeEach
    void setupMockBeans() {MockitoAnnotations.openMocks(this);
    }

    @Test
    void Should_Return_BusinessException_IfNotFound() {
        String city = "InvalidCity";
        when(this.weatherRepository.getWeatherDetailByCity(city)).thenThrow(BusinessException.class);
        Assertions.assertThrows(BusinessException.class,
                () -> weatherService.getWeatherDetailByCity(city));
    }


    @Test
    void Should_Return_City_IfExist() {
        String city = "Haarlem";
        WeatherDTO weatherDTO = WeatherDTO.builder()
                .cityName(city)
                .temperature("21").build();

        Weather weather = Weather.builder()
                .id(UUID.randomUUID())
                .cityName(city)
                .temperature("21").build();

        doReturn(Optional.of(weather)).when(this.weatherRepository).getWeatherDetailByCity(city);
        doReturn(weatherDTO).when(this.weatherMapper).entityToDto(weather);

        WeatherDTO response = weatherService.getWeatherDetailByCity(city);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(city, response.getCityName());
    }
}
