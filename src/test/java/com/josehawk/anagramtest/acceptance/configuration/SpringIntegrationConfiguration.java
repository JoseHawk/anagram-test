package com.josehawk.anagramtest.acceptance.configuration;

import com.josehawk.anagramtest.AnagramTestApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(
        classes = AnagramTestApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@CucumberContextConfiguration
@ActiveProfiles("acceptance")
public class SpringIntegrationConfiguration {
}
