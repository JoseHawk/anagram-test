package com.josehawk.anagramtest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.josehawk.anagramtest.controllers.dto.ComparisonRequest;
import com.josehawk.anagramtest.controllers.dto.ComparisonResponse;
import com.josehawk.anagramtest.controllers.dto.MeaningfulComparisonResponse;
import com.josehawk.anagramtest.services.AnagramService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AnagramController.class)
public class AnagramControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AnagramService anagramService;

    @Test
    void checkIfSimpleAnagramTest() throws Exception {
        var comparisonRequest = ComparisonRequest.builder()
                .firstWord("firstWord")
                .secondWord("secondWord")
                .shouldRemoveSpecialCharacters(true)
                .build();
        var expectedComparisonResponse = ComparisonResponse.builder()
                .isAnagram(false)
                .build();
        when(anagramService.checkIfSimpleAnagram("firstWord", "secondWord", true))
                .thenReturn(expectedComparisonResponse);
        var body = objectMapper.writeValueAsString(comparisonRequest);

        var mvcResponse = mvc.perform(post("/simple")
                        .contentType("application/json")
                        .content(body))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        var actualComparisonResponse = new ObjectMapper().readValue(mvcResponse, ComparisonResponse.class);

        assertEquals(expectedComparisonResponse, actualComparisonResponse);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void checkIfSimpleAnagramBadRequestDueToNullOrEmptyValue(String firstWord) throws Exception {
        var comparisonRequest = ComparisonRequest.builder()
                .firstWord(firstWord)
                .secondWord("secondWord")
                .shouldRemoveSpecialCharacters(true)
                .build();
        var body = objectMapper.writeValueAsString(comparisonRequest);

        mvc.perform(post("/simple")
                        .contentType("application/json")
                        .content(body))
                .andExpect(status().isBadRequest());
    }

    @Test
    void checkIfMeaningfulAnagramTest() throws Exception {
        var comparisonRequest = ComparisonRequest.builder()
                .firstWord("firstWord")
                .secondWord("secondWord")
                .shouldRemoveSpecialCharacters(true)
                .build();
        var expectedComparisonResponse = MeaningfulComparisonResponse.builder()
                .isAnagram(false)
                .wordsAreMeaningful(false)
                .build();
        when(anagramService.checkIfMeaningfulAnagram("firstWord", "secondWord", true))
                .thenReturn(expectedComparisonResponse);
        var body = objectMapper.writeValueAsString(comparisonRequest);

        var mvcResponse = mvc.perform(post("/meaningful")
                        .contentType("application/json")
                        .content(body))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        var actualComparisonResponse = new ObjectMapper().readValue(mvcResponse, MeaningfulComparisonResponse.class);

        assertEquals(expectedComparisonResponse, actualComparisonResponse);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void checkIfMeaningfulAnagramBadRequestDueToNullOrEmptyValue(String firstWord) throws Exception {
        var comparisonRequest = ComparisonRequest.builder()
                .firstWord(firstWord)
                .secondWord("secondWord")
                .shouldRemoveSpecialCharacters(true)
                .build();
        var body = objectMapper.writeValueAsString(comparisonRequest);

        mvc.perform(post("/meaningful")
                        .contentType("application/json")
                        .content(body))
                .andExpect(status().isBadRequest());
    }
}
