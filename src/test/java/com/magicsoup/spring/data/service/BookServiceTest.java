package com.magicsoup.spring.data.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.magicsoup.spring.data.config.DefaultSpringBootTest;
import com.magicsoup.spring.data.model.bean.BookBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DefaultSpringBootTest
class BookServiceTest {

    private static final int HEAD_FIRST_JAVA_ID = 1;

    private static final int KATHY_SIERRA_ID = 1;

    @Autowired
    private BookService bookService;

    @Test
    void findById() {

        // Execute
        BookBean book = bookService.findById(HEAD_FIRST_JAVA_ID);

        // Assert && Verify
        assertThat(book).isNotNull().satisfies(result -> {
            assertThat(result.getTitle()).isEqualTo("Head First Java");
            assertThat(result.getAuthors())
                    .containsExactlyInAnyOrderElementsOf(
                            List.of("Kathy Sierra",
                                    "Bert Bates"));
        });
    }

    @Test
    void findByAuthorId() {

        // Execute
        List<BookBean> bookList = bookService.findByAuthorId(KATHY_SIERRA_ID);

        // Assert && Verify
        assertThat(bookList).hasSize(3).satisfies(books -> {
            assertThat(books).extracting(BookBean::getTitle)
                    .containsExactlyInAnyOrderElementsOf(
                            List.of("Head First Java",
                                    "Head First Servlets and JSP",
                                    "OCA/OCP Java SE 7 Programmer"));
        });
    }
}