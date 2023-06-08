package com.josehawk.anagramtest.acceptance.steps.then;

import com.josehawk.anagramtest.acceptance.models.AnagramTestWorld;
import com.josehawk.anagramtest.controllers.dto.ComparisonResponse;
import com.josehawk.anagramtest.controllers.dto.MeaningfulComparisonResponse;
import io.cucumber.java.en.Then;
import lombok.AllArgsConstructor;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@AllArgsConstructor
public class ThenTheUserReceivesTheResponseSayingThatIsAnAnagramButNotMeaningful {

    private final AnagramTestWorld anagramTestWorld;

    @Then("The user receives a response saying that is an anagram but not meaningful")
    public void the_user_receives_the_response_saying_that_is_an_anagram_but_not_meaningful() {
        MeaningfulComparisonResponse comparisonResponse = anagramTestWorld.getLastResponse().getBody().as(MeaningfulComparisonResponse.class);

        assertTrue(comparisonResponse.isAnagram());
        assertFalse(comparisonResponse.wordsAreMeaningful());
    }
}
