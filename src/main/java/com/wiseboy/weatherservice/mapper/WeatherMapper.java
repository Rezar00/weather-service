package com.wiseboy.weatherservice.mapper;

import com.wiseboy.weatherservice.dto.WeatherDTO;
import com.wiseboy.weatherservice.entity.Weather;
import org.mapstruct.Mapper;

@Mapper
public interface WeatherMapper extends GenericMapper<Weather, WeatherDTO> {
}
