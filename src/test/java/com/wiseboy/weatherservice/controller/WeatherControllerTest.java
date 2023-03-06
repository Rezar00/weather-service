package com.wiseboy.weatherservice.controller;

import com.wiseboy.weatherservice.exception.BusinessException;
import com.wiseboy.weatherservice.service.WeatherServiceApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WeatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherServiceApi weatherService;


    @Test
    void Should_Throw_NotFoundException() throws Exception {
        String city = "invalidCity";
        when(this.weatherService.getWeatherDetailByCity(city))
                .thenThrow(new BusinessException("City Information Is Not Found", HttpStatus.NOT_FOUND.value()));

        this.mockMvc.perform(get("/api/v1/weather").contentType(MediaType.APPLICATION_JSON)
                        .param("city", city))
                .andExpect(status().isNotFound());
    }

}
