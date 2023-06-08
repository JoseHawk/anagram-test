package com.josehawk.anagramtest.acceptance.configuration;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import org.junit.Rule;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;

@Configuration
@Profile("acceptance")
public class WiremockConfiguration {

    @Rule
    WireMockRule wireMockRule = new WireMockRule(50000);

    public WiremockConfiguration() {
        wireMockRule.addStubMapping(setStubs(0, wireMockRule));
        wireMockRule.addStubMapping(setStubs(1, wireMockRule));

        wireMockRule.start();
    }

    public StubMapping setStubs(int index, WireMockServer wireMockServer) {
        return switch (index) {
            case 0 -> wireMockServer.stubFor(get(urlMatching("https://api.dictionaryapi.dev/api/v2/entries/en/hello"))
                    .inScenario("DictionaryCall")
                    .whenScenarioStateIs("Started")
                    .willSetStateTo("FirstState")
                    .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type", "application/json")
                            .withBodyFile("dictionary_response_ok.json"))
            );
            case 1 -> wireMockServer.stubFor(get(urlMatching("https://api.dictionaryapi.dev/api/v2/entries/en/olleh"))
                    .inScenario("DictionaryCall")
                    .whenScenarioStateIs("FirstState")
                    .willSetStateTo("Started")
                    .willReturn(aResponse()
                            .withStatus(204)
                            .withHeader("Content-Type", "application/json")
                            .withBodyFile("dictionary_response_ko.json"))
            );
            default -> null;
        };
    }
}
