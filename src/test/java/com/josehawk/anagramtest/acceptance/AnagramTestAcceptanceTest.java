package com.josehawk.anagramtest.acceptance;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features")
@ActiveProfiles("acceptance")
public class AnagramTestAcceptanceTest {
}
