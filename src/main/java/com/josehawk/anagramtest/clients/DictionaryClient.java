package com.josehawk.anagramtest.clients;

import com.josehawk.anagramtest.clients.dto.DictionaryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "dictionary", url = "${dictionary.url}", dismiss404 = true)
public interface DictionaryClient {

    @GetMapping("/{word}")
    Optional<List<DictionaryResponse>> read(@PathVariable("word") String word);
}
