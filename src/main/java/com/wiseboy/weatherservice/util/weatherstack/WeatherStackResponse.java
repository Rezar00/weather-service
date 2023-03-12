package com.wiseboy.weatherservice.util.weatherstack;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherStackResponse implements Serializable {
    private Request request;
    private Location location;
    private Current current;
}
