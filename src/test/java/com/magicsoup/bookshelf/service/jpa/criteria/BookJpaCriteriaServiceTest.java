package com.magicsoup.bookshelf.service.jpa.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.magicsoup.bookshelf.config.DefaultSpringBootTest;
import com.magicsoup.bookshelf.model.bean.BookBean;
import com.magicsoup.bookshelf.model.bean.TemporalGrouping;
import com.magicsoup.bookshelf.service.jpa.CommonBookJpaService;

@DefaultSpringBootTest
class BookJpaCriteriaServiceTest extends CommonBookJpaService {

    @Autowired
    private BookJpaCriteriaService bookJpaCriteriaService;

    @ParameterizedTest
    @ValueSource(strings = {"YEAR", "MONTH", "DAY"})
    void countBookGroupByPublishedAt(String chronoField) {
        // Execute && Assert && Verify
        Map<String, Long> map = bookJpaCriteriaService.countBookGroupByPublishedAt(TemporalGrouping.valueOf(chronoField));

        // Add assertion in order to be compliant with sonar
        assertThat(map).isNotEmpty();
    }

    @Test
    void findByBookId() {
        // Execute && Assert && Verify
        BookBean book = testFindByBookId(bookJpaCriteriaService, HEAD_FIRST_JAVA_ID);

        // Add assertion in order to be compliant with sonar
        assertThat(book).isNotNull();
    }

    @Test
    void findByAuthorId() {
        // Execute && Assert && Verify
        List<BookBean> books = testFindByAuthorId(bookJpaCriteriaService, KATHY_SIERRA_ID);

        // Add assertion in order to be compliant with sonar
        assertThat(books).isNotEmpty();
    }
}