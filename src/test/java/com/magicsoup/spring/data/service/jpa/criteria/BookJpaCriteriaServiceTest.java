package com.magicsoup.spring.data.service.jpa.criteria;

import com.magicsoup.spring.data.config.DefaultSpringBootTest;
import com.magicsoup.spring.data.model.bean.BookBean;
import com.magicsoup.spring.data.service.jpa.CommonBookJpaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DefaultSpringBootTest
class BookJpaCriteriaServiceTest extends CommonBookJpaService {

    @Autowired
    private BookJpaCriteriaService bookJpaCriteriaService;


    @ParameterizedTest
    @ValueSource(strings = {"YEAR", "MONTH_OF_YEAR", "DAY_OF_MONTH"})
    void countBookGroupByPublishedAt(String chronoField) {
        // Execute && Assert && Verify
        Map<String, Long> map = bookJpaCriteriaService.countBookGroupByPublishedAt(ChronoField.valueOf(chronoField));

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