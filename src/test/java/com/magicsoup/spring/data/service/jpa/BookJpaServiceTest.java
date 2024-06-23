package com.magicsoup.spring.data.service.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.magicsoup.spring.data.config.DefaultSpringBootTest;
import com.magicsoup.spring.data.model.bean.BookBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DefaultSpringBootTest
class BookJpaServiceTest extends CommonBookJpaService {

    @Autowired
    private BookJpaService bookJpaService;

    @Test
    void findByBookId() {
        // Execute && Assert && Verify
        BookBean book = testFindByBookId(bookJpaService, HEAD_FIRST_JAVA_ID);

        // Add assertion in order to be compliant with sonar
        assertThat(book).isNotNull();
    }

    @Test
    void findByAuthorId() {
        // Execute && Assert && Verify
        List<BookBean> books = testFindByAuthorId(bookJpaService, KATHY_SIERRA_ID);

        // Add assertion in order to be compliant with sonar
        assertThat(books).isNotEmpty();
    }
}