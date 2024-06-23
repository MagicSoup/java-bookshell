package com.magicsoup.spring.data.service.jpa;

import com.magicsoup.spring.data.config.DefaultSpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DefaultSpringBootTest
class BookJpaServiceTest extends CommonBookJpaService {

    @Autowired
    private BookJpaService bookJpaService;

    @Test
    void findByBookId() {
        // Execute && Assert && Verify
        findByBookId(bookJpaService, HEAD_FIRST_JAVA_ID);
    }

    @Test
    void findByAuthorId() {
        // Execute && Assert && Verify
        findByAuthorId(bookJpaService, KATHY_SIERRA_ID);
    }
}