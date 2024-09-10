package com.magicsoup.bookshelf.service.jpa.specification;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.magicsoup.bookshelf.config.DefaultSpringBootTest;
import com.magicsoup.bookshelf.model.bean.BookBean;
import com.magicsoup.bookshelf.model.entity.AuthorEntity;
import com.magicsoup.bookshelf.model.entity.BookEntity;
import com.magicsoup.bookshelf.repository.jpa.specification.BookJpaSpecificationRepository;
import com.magicsoup.bookshelf.service.jpa.CommonBookJpaService;


class BookJpaSpecificationServiceTest {

    @Nested
    @ExtendWith(MockitoExtension.class)
    class UnitTests {

        @Mock
        private BookJpaSpecificationRepository bookJpaSpecificationRepositoryMocked;

        @InjectMocks
        private BookJpaSpecificationService underTests;

        @Test
        void getAll() {

            // mock
            AuthorEntity authorEntity = new AuthorEntity(1, "Daniel", "Defoe");
            BookEntity bookEntity = new BookEntity(1, "Robinson Crusoe", List.of(authorEntity), LocalDate.now());
            doReturn(List.of(bookEntity))
                    .when(bookJpaSpecificationRepositoryMocked).findAll();

            // execute
            List<BookBean> result = underTests.getAll();

            // assert && verify
            BookBean book = new BookBean("Robinson Crusoe", List.of("Daniel Defoe"));
            assertThat(result).hasSize(1);
            assertThat(result).containsExactly(book);

            verify(bookJpaSpecificationRepositoryMocked, times(1)).findAll();
        }

    }


    @Nested
    @DefaultSpringBootTest
    class IntegrationTests extends CommonBookJpaService {

        @Autowired
        private BookJpaSpecificationService underTests;

        @Test
        void findByBookId() {
            // Execute && Assert && Verify
            BookBean book = testFindByBookId(underTests, HEAD_FIRST_JAVA_ID);

            // Add assertion in order to be compliant with sonar
            assertThat(book).isNotNull();
        }

        @Test
        void findByAuthorId() {
            // Execute && Assert && Verify
            List<BookBean> books = testFindByAuthorId(underTests, KATHY_SIERRA_ID);

            // Add assertion in order to be compliant with sonar
            assertThat(books).isNotEmpty();
        }
    }

}