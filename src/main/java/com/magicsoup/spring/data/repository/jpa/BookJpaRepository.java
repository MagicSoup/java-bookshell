package com.magicsoup.spring.data.repository.jpa;

import java.util.List;

import com.magicsoup.spring.data.model.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

/**
 * JPA repository implementation to find books
 */
public interface BookJpaRepository extends JpaRepository<BookEntity, Integer> {

    @Nullable
    @Query("SELECT b FROM BookEntity b LEFT OUTER JOIN FETCH b.authors a WHERE b.id = (:bookId)")
    BookEntity findByBookId(@Param("bookId") Integer bookId);

    @Query("SELECT b FROM BookEntity b INNER JOIN FETCH b.authors a WHERE a.id = (:authorId)")
    List<BookEntity> findByAuthorId(@Param("authorId") Integer authorId);
}
