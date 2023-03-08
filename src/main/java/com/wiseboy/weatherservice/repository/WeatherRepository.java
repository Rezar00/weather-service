package com.wiseboy.weatherservice.repository;

import com.wiseboy.weatherservice.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface WeatherRepository extends JpaRepository<UUID, Weather> {

    @Query(value = "select w from Weather w where w.cityName = :city")
    Optional<Weather> getWeatherDetailByCity(String city);
}
