package com.josehawk.anagramtest.services;

import com.josehawk.anagramtest.clients.DictionaryClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class DictionaryService {

    private final DictionaryClient dictionaryClient;

    public boolean checkIfWordExistsInDictionary(String word) {
        log.info("Checking if the word {} exists", word);
        return dictionaryClient.read(word).isPresent();
    }
}
