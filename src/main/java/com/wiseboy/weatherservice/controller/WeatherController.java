package com.wiseboy.weatherservice.controller;

import com.wiseboy.weatherservice.dto.WeatherDTO;
import com.wiseboy.weatherservice.service.WeatherServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherServiceApi weatherService;
    @GetMapping("/{city}")
    public ResponseEntity<WeatherDTO> getWeatherInformationByCity(@PathVariable String city) {
        return ResponseEntity.ok(this.weatherService.getWeatherDetailByCity(city));
    }
}
