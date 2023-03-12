package com.wiseboy.weatherservice.repository;

import com.wiseboy.weatherservice.entity.Weather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@DataJpaTest
@ExtendWith(value = SpringExtension.class)
@TestPropertySource(value = "classpath:application-test.yml")
@Sql(scripts = {"classpath:schema.sql"})
class WeatherRepositoryTest {

    @Autowired
    private WeatherRepository weatherRepository;
    @Test
    void Should_Return_All_Weather_Information() {
        List<Weather> weathers = weatherRepository.findAll();

        Assertions.assertEquals(1, weathers.size());
    }
}
