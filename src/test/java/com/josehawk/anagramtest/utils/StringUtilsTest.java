package com.josehawk.anagramtest.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.josehawk.anagramtest.utils.StringUtils.cleanString;
import static com.josehawk.anagramtest.utils.StringUtils.isAnagram;
import static com.josehawk.anagramtest.utils.StringUtils.removeSpecialCharacters;
import static com.josehawk.anagramtest.utils.StringUtils.retrieveWordsList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilsTest {

    @ParameterizedTest
    @CsvSource({"#Héllò^,Hello", "Wörld!,World"})
    void removeSpecialCharactersTest(String text, String expectedResult) {
        assertEquals(expectedResult, removeSpecialCharacters(text));
    }

    @ParameterizedTest
    @MethodSource("cleanTestValues")
    void cleanStringTest(String text, String expectedResult) {
        assertEquals(expectedResult, cleanString(text));
    }

    @ParameterizedTest
    @MethodSource("anagramValues")
    void isAnagramTest(String firstWord, String secondWord) {
        assertTrue(isAnagram(firstWord, secondWord));
    }

    @ParameterizedTest
    @MethodSource("wordListValues")
    void retrieveWordsListTest(String word, List<String> expectedList) {
        assertEquals(expectedList, retrieveWordsList(word));
    }

    private static Stream<Arguments> cleanTestValues() {
        return Stream.of(
                Arguments.of("a gentleman", "agentleman"),
                Arguments.of("Fourth of July", "fourthofjuly"),
                Arguments.of(" the Morse Code ", "themorsecode")
        );
    }

    private static Stream<Arguments> anagramValues() {
        return Stream.of(
                Arguments.of("a gentleman", "elegant man"),
                Arguments.of("astronomer", "moon starer"),
                Arguments.of("Christmas", "trims cash"),
                Arguments.of("conversation", "voices rant on"),
                Arguments.of("dormitory", "dirty room"),
                Arguments.of("eleven plus two", "twelve plus one"),
                Arguments.of("Fourth of July", "joyful Fourth"),
                Arguments.of("the Morse Code", "here come dots")
        );
    }

    private static Stream<Arguments> wordListValues() {
        return Stream.of(
                Arguments.of("a gentleman", List.of("a", "gentleman")),
                Arguments.of("eleven plus two", List.of("eleven", "plus", "two")),
                Arguments.of("Fourth of July", List.of("Fourth", "of", "July")),
                Arguments.of("the Morse Code", List.of("the", "Morse", "Code"))
        );
    }
}
