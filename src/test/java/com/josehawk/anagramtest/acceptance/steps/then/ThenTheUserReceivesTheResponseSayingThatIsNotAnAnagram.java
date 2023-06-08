package com.josehawk.anagramtest.acceptance.steps.then;

import com.josehawk.anagramtest.acceptance.models.AnagramTestWorld;
import com.josehawk.anagramtest.controllers.dto.ComparisonResponse;
import io.cucumber.java.en.Then;
import lombok.AllArgsConstructor;

import static org.junit.jupiter.api.Assertions.assertFalse;

@AllArgsConstructor
public class ThenTheUserReceivesTheResponseSayingThatIsNotAnAnagram {

    private final AnagramTestWorld anagramTestWorld;

    @Then("The user receives a response saying that is not an anagram")
    public void the_user_receives_the_response_saying_that_is_not_an_anagram() {
        ComparisonResponse comparisonResponse = anagramTestWorld.getLastResponse().getBody().as(ComparisonResponse.class);

        assertFalse(comparisonResponse.isAnagram());
    }
}
