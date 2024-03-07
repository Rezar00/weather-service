package com.wiseboy.weatherservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}


	@TestConfiguration
	static class TestConfig {
		@Bean
		public JwtDecoder jwtDecoder() {
			return token -> Jwt.withTokenValue("mock").build();
		}
	}

}
