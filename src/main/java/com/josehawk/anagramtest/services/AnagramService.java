package com.josehawk.anagramtest.services;

import com.josehawk.anagramtest.controllers.dto.ComparisonResponse;
import com.josehawk.anagramtest.controllers.dto.MeaningfulComparisonResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.josehawk.anagramtest.utils.StringUtils.isAnagram;
import static com.josehawk.anagramtest.utils.StringUtils.removeSpecialCharacters;
import static com.josehawk.anagramtest.utils.StringUtils.retrieveWordsList;

@Service
@AllArgsConstructor
@Slf4j
public class AnagramService {

    private final DictionaryService dictionaryService;

    public ComparisonResponse checkIfSimpleAnagram(String firstWord, String secondWord, boolean shouldRemoveSpecialCharacters) {
        log.info("Checking if {} and {} are anagram. Special characters should be removed: {}", firstWord, secondWord, shouldRemoveSpecialCharacters);
        return ComparisonResponse.builder()
                .isAnagram(checkIfAnagram(firstWord, secondWord, shouldRemoveSpecialCharacters))
                .build();
    }

    public MeaningfulComparisonResponse checkIfMeaningfulAnagram(String firstWord, String secondWord, boolean shouldRemoveSpecialCharacters) {
        log.info("Checking if {} and {} are anagram. Special characters should be removed: {}", firstWord, secondWord, shouldRemoveSpecialCharacters);
        var comparisonResponse = checkIfAnagram(firstWord, secondWord, shouldRemoveSpecialCharacters);
        log.info("Retrieving the list of appearing words in the original texts");
        var appearingWords = retrieveWordsList(firstWord, secondWord);
        log.info("Checking if the appearing words are all meaningful in an individual context: " + appearingWords);
        var allWordsMeaningful = appearingWords.stream()
                .allMatch(dictionaryService::checkIfWordExistsInDictionary);

        return MeaningfulComparisonResponse.builder()
                .isAnagram(comparisonResponse)
                .wordsAreMeaningful(allWordsMeaningful)
                .build();
    }

    private boolean checkIfAnagram(String firstWord, String secondWord, boolean shouldRemoveSpecialCharacters) {
        if (shouldRemoveSpecialCharacters) {
            firstWord = removeSpecialCharacters(firstWord);
            secondWord = removeSpecialCharacters(secondWord);
        }

        return isAnagram(firstWord, secondWord);
    }
}
