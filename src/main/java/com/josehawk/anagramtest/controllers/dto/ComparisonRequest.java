package com.josehawk.anagramtest.controllers.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ComparisonRequest(@NotNull @NotEmpty String firstWord,
                                @NotNull @NotEmpty String secondWord,
                                boolean shouldRemoveSpecialCharacters) {
}
