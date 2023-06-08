package com.josehawk.anagramtest.acceptance.configuration;

import io.restassured.RestAssured;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Configuration
@Profile("acceptance")
public class RestAssuredConfiguration {

    public RestAssuredConfiguration(Environment environment) {

        RestAssured.port = Integer.valueOf(environment.getProperty("server.port"));
    }
}
