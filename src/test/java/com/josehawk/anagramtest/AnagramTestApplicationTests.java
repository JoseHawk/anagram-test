package com.josehawk.anagramtest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = "DICTIONARY_URL=http://domain.com")
class AnagramTestApplicationTests {

    @Test
    void contextLoads() {
    }
}
