package com.magicsoup.spring.data.service.jpa.specification;

import com.magicsoup.spring.data.config.DefaultSpringBootTest;
import com.magicsoup.spring.data.service.jpa.CommonBookJpaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DefaultSpringBootTest
class BookJpaSpecificationServiceTest extends CommonBookJpaService {

    @Autowired
    private BookJpaSpecificationService bookJpaSpecificationService;

    @Test
    void findByBookId() {
        // Execute && Assert && Verify
        findByBookId(bookJpaSpecificationService, HEAD_FIRST_JAVA_ID);
    }

    @Test
    void findByAuthorId() {
        // Execute && Assert && Verify
        findByAuthorId(bookJpaSpecificationService, KATHY_SIERRA_ID);
    }
}