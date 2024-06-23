package com.magicsoup.spring.data.service.jpa.criteria;

import com.magicsoup.spring.data.config.DefaultSpringBootTest;
import com.magicsoup.spring.data.service.jpa.CommonBookJpaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DefaultSpringBootTest
class BookJpaCriteriaServiceTest extends CommonBookJpaService {

    @Autowired
    private BookJpaCriteriaService bookJpaCriteriaService;


    @Test
    void findByBookId() {
        // Execute && Assert && Verify
        findByBookId(bookJpaCriteriaService, HEAD_FIRST_JAVA_ID);
    }

    @Test
    void findByAuthorId() {
        // Execute && Assert && Verify
        findByAuthorId(bookJpaCriteriaService, KATHY_SIERRA_ID);
    }
}