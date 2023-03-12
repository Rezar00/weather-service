package com.wiseboy.weatherservice.util.weatherstack;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Current implements Serializable {

    private String observation_time;
    private String temperature;
    private String weather_code;
    private String[] weather_icons;
    private String[] weather_descriptions;
    private String wind_speed;
    private String wind_degree;
    private String wind_dir;
    private String pressure;
    private String precip;
    private String humidity;
    private String cloudcover;
    private String feelslike;
    private String uv_index;
    private String visibility;
    private String is_day;
}
