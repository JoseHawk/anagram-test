package com.josehawk.anagramtest.acceptance.steps.when;

import com.josehawk.anagramtest.acceptance.models.AnagramTestWorld;
import com.josehawk.anagramtest.controllers.dto.ComparisonRequest;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;

import static io.restassured.RestAssured.given;

@AllArgsConstructor
public class WhenTheUserChecksForSimpleAnagramComparisonWithoutRemovingSpecialCharacters {

    private final AnagramTestWorld anagramTestWorld;

    @When("The user checks for simple anagram comparison without removing special characters")
    public void the_user_checks_for_simple_anagram_comparison_without_removing_special_characters() {
        ComparisonRequest comparisonRequest = new ComparisonRequest("#the Morsé Codé", "here come dots    ", false);

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(comparisonRequest)
                .when()
                .post("/anagram-api/simple")
                .then()
                .extract().response();

        anagramTestWorld.setLastResponse(response);
    }
}
