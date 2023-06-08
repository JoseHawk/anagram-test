package com.josehawk.anagramtest.utils;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    public static String removeSpecialCharacters(String text) {
        return Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .replaceAll("[^\\p{Alnum}]+", "");
    }

    public static String cleanString(String text) {
        return text.toLowerCase().strip().replaceAll(" ", "");
    }

    public static boolean isAnagram(String firstText, String secondText) {
        var cleanFirstText = cleanString(firstText);
        var cleanSecondText = cleanString(secondText);

        if (cleanFirstText.length() != cleanSecondText.length()) {
            return false;
        }

        var firstWordCharacters = cleanFirstText.toCharArray();
        Arrays.sort(firstWordCharacters);
        var secondWordCharacters = cleanSecondText.toCharArray();
        Arrays.sort(secondWordCharacters);

        return Arrays.equals(firstWordCharacters, secondWordCharacters);
    }

    public static List<String> retrieveWordsList(String... texts) {
        return Arrays.stream(texts)
                .flatMap(text -> Arrays.stream(text.split("\\s+")))
                .collect(Collectors.toList());
    }
}
