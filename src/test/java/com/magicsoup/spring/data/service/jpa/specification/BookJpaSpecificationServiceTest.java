package com.magicsoup.spring.data.service.jpa.specification;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.magicsoup.spring.data.config.DefaultSpringBootTest;
import com.magicsoup.spring.data.model.bean.BookBean;
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
        BookBean book = testFindByBookId(bookJpaSpecificationService, HEAD_FIRST_JAVA_ID);

        // Add assertion in order to be compliant with sonar
        assertThat(book).isNotNull();
    }

    @Test
    void findByAuthorId() {
        // Execute && Assert && Verify
        List<BookBean> books = testFindByAuthorId(bookJpaSpecificationService, KATHY_SIERRA_ID);

        // Add assertion in order to be compliant with sonar
        assertThat(books).isNotEmpty();
    }
}