package com.josehawk.anagramtest.services;

import com.josehawk.anagramtest.controllers.dto.ComparisonResponse;
import com.josehawk.anagramtest.controllers.dto.MeaningfulComparisonResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AnagramServiceTest {

    @InjectMocks
    private AnagramService anagramService;

    @Mock
    private DictionaryService dictionaryService;

    @Test
    void checkIfSimpleAnagramTest() {
        var expectedComparisonResponse = ComparisonResponse.builder()
                .isAnagram(true)
                .build();

        var actualComparisonResponse = anagramService.checkIfSimpleAnagram("á gentleman#", "%elegánt man^@", true);

        assertEquals(expectedComparisonResponse, actualComparisonResponse);
    }

    @Test
    void checkIfMeaningfulAnagramTest() {
        var expectedComparisonResponse = MeaningfulComparisonResponse.builder()
                .isAnagram(true)
                .wordsAreMeaningful(true)
                .build();
        when(dictionaryService.checkIfWordExistsInDictionary(any())).thenReturn(true);

        var actualComparisonResponse = anagramService.checkIfMeaningfulAnagram("a gentleman", "elegant man", true);

        assertEquals(expectedComparisonResponse, actualComparisonResponse);
    }
}
