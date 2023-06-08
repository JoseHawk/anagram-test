package com.josehawk.anagramtest.controllers.dto;

import lombok.Builder;

@Builder
public record ComparisonResponse(boolean isAnagram) {
}
