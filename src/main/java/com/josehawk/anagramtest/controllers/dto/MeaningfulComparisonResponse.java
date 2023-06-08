package com.josehawk.anagramtest.controllers.dto;

import lombok.Builder;

@Builder
public record MeaningfulComparisonResponse(boolean isAnagram,
                                           boolean wordsAreMeaningful) {
}
