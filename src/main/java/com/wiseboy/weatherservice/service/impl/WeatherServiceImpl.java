package com.wiseboy.weatherservice.service.impl;

import com.wiseboy.weatherservice.adapter.WeatherStackAdapter;
import com.wiseboy.weatherservice.dto.WeatherDTO;
import com.wiseboy.weatherservice.mapper.WeatherMapper;
import com.wiseboy.weatherservice.repository.WeatherRepository;
import com.wiseboy.weatherservice.service.WeatherServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherServiceApi {
    private final WeatherRepository weatherRepository;
    private final WeatherMapper weatherMapper;

    private final WeatherStackAdapter weatherStackAdapter;

    @Override
    @Transactional(readOnly = true)
    public WeatherDTO getWeatherDetailByCity(String cityName) {

        return this.weatherStackAdapter.getWeatherStatusByCity(cityName);
    }
}
