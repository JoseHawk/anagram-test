package com.josehawk.anagramtest.controllers;

import com.josehawk.anagramtest.controllers.dto.ComparisonRequest;
import com.josehawk.anagramtest.controllers.dto.ComparisonResponse;
import com.josehawk.anagramtest.controllers.dto.MeaningfulComparisonResponse;
import com.josehawk.anagramtest.services.AnagramService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AnagramController {

    private final AnagramService anagramService;

    @PostMapping("/simple")
    public ResponseEntity<ComparisonResponse> checkIfSimpleAnagram(@RequestBody @Valid ComparisonRequest comparisonRequest) {
        return ResponseEntity.ok(anagramService.checkIfSimpleAnagram(comparisonRequest.firstWord(),
                comparisonRequest.secondWord(),
                comparisonRequest.shouldRemoveSpecialCharacters()));
    }

    @PostMapping("/meaningful")
    public ResponseEntity<MeaningfulComparisonResponse> checkIfMeaningfulAnagram(@RequestBody @Valid ComparisonRequest comparisonRequest) {
        return ResponseEntity.ok(anagramService.checkIfMeaningfulAnagram(comparisonRequest.firstWord(),
                comparisonRequest.secondWord(),
                comparisonRequest.shouldRemoveSpecialCharacters()));
    }
}
