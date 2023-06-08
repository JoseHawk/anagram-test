package com.josehawk.anagramtest.services;

import com.josehawk.anagramtest.clients.DictionaryClient;
import com.josehawk.anagramtest.clients.dto.DictionaryResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DictionaryServiceTest {

    @InjectMocks
    private DictionaryService dictionaryService;

    @Mock
    private DictionaryClient dictionaryClient;

    @Test
    void checkIfWordExistsInDictionaryTest() {
        var dictionaryResponse = DictionaryResponse.builder()
                        .word("hello")
                        .build();
        when(dictionaryClient.read("hello")).thenReturn(Optional.of(List.of(dictionaryResponse)));

        assertTrue(dictionaryService.checkIfWordExistsInDictionary("hello"));
    }
}
