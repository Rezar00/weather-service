package com.wiseboy.weatherservice.service;

import com.wiseboy.weatherservice.dto.WeatherDTO;

public interface WeatherServiceApi {

    WeatherDTO getWeatherDetailByCity(String cityName);
}
