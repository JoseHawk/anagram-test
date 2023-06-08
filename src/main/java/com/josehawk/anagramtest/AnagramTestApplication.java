package com.josehawk.anagramtest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication
@OpenAPIDefinition
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class AnagramTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnagramTestApplication.class, args);
    }
}
