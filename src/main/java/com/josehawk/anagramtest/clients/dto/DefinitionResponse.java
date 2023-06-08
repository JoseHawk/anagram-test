package com.josehawk.anagramtest.clients.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record DefinitionResponse(String definition,
                                 List<String> synonyms,
                                 List<String> antonyms) {
}
