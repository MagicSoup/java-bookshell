package com.magicsoup.bookshell.service.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.magicsoup.bookshell.model.bean.BookBean;
import com.magicsoup.bookshell.service.IBookService;

public class CommonBookJpaService {

    protected static final int HEAD_FIRST_JAVA_ID = 1;

    protected static final int KATHY_SIERRA_ID = 1;

    protected BookBean testFindByBookId(IBookService service, Integer bookId) {

        // Execute
        BookBean book = service.findByBookId(bookId);

        // Assert && Verify
        assertThat(book).isNotNull().satisfies(result -> {
            assertThat(result.getTitle()).isEqualTo("Head First Java");
            assertThat(result.getAuthors())
                    .containsExactlyInAnyOrderElementsOf(
                            List.of("Kathy Sierra",
                                    "Bert Bates"));
        });

        return book;
    }

    protected List<BookBean> testFindByAuthorId(IBookService service, Integer authorId) {

        // Execute
        List<BookBean> bookList = service.findByAuthorId(authorId);

        // Assert && Verify
        assertThat(bookList).hasSize(3).satisfies(books -> {
            assertThat(books).extracting(BookBean::getTitle)
                    .containsExactlyInAnyOrderElementsOf(
                            List.of("Head First Java",
                                    "Head First Servlets and JSP",
                                    "OCA/OCP Java SE 7 Programmer"));
        });

        return bookList;
    }
}
