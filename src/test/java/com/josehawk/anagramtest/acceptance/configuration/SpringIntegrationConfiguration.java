package com.josehawk.anagramtest.acceptance.configuration;

import com.josehawk.anagramtest.AnagramTestApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(
        classes = AnagramTestApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@CucumberContextConfiguration
@ActiveProfiles("acceptance")
@TestPropertySource(properties = {
        "DICTIONARY_URL=https://api.dictionaryapi.dev/api/v2/entries/en",
        "server.port=8091"
})
public class SpringIntegrationConfiguration {
}
