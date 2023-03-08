package com.wiseboy.weatherservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherDTO {
    private String cityName;
    private String temperature;
}
