package com.josehawk.anagramtest.clients.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record DictionaryResponse(String word,
                                 List<MeaningResponse> meanings) {
}
