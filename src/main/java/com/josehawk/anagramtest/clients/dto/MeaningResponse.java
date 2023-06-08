package com.josehawk.anagramtest.clients.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record MeaningResponse(String partOfSpeech,
                              List<DefinitionResponse> definitions) {
}
