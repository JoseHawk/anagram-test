package com.josehawk.anagramtest.acceptance.models;

import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class AnagramTestWorld {

    @Getter
    @Setter
    private Response lastResponse;
}
