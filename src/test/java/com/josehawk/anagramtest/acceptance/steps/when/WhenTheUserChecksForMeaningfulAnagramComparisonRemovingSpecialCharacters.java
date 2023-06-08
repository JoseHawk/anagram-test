package com.josehawk.anagramtest.acceptance.steps.when;

import com.josehawk.anagramtest.acceptance.models.AnagramTestWorld;
import com.josehawk.anagramtest.controllers.dto.ComparisonRequest;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;

import static io.restassured.RestAssured.given;

@AllArgsConstructor
public class WhenTheUserChecksForMeaningfulAnagramComparisonRemovingSpecialCharacters {

    private final AnagramTestWorld anagramTestWorld;

    @When("The user checks for meaningful anagram comparison removing special characters")
    public void the_user_checks_for_meaningful_anagram_comparison_removing_special_characters() {
        ComparisonRequest comparisonRequest = new ComparisonRequest("#Hélló", "olleh", true);

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(comparisonRequest)
                .when()
                .post("/anagram-api/meaningful")
                .then()
                .extract().response();

        anagramTestWorld.setLastResponse(response);
    }
}
