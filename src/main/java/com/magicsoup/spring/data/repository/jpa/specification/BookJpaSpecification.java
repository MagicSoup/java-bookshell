package com.magicsoup.spring.data.repository.jpa.specification;

import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Path;

import org.springframework.data.jpa.domain.Specification;

import com.magicsoup.spring.data.model.entity.AuthorEntity_;
import com.magicsoup.spring.data.model.entity.BookEntity;
import com.magicsoup.spring.data.model.entity.BookEntity_;

/**
 * JPA Specification implementation to find books
 */
public final class BookJpaSpecification {

    private BookJpaSpecification() {
    }

    /**
     * Specification to find books by author id
     *
     * @param authorId the author id
     * @return the specification to find books by author id
     */
    public static Specification<BookEntity> byAuthorId(Integer authorId) {
        return (root, query, criteriaBuilder) -> {
            root.fetch(BookEntity_.authors, JoinType.INNER);
            Path<Integer> authorIdPath = root.get(BookEntity_.AUTHORS).get(AuthorEntity_.ID);
            return criteriaBuilder.equal(authorIdPath, authorId);
        };
    }

    /**
     * Specification to find a book by id
     *
     * @param bookId the book id
     * @return the specification to find a book by id
     */
    public static Specification<BookEntity> byBookId(Integer bookId) {
        return (root, query, criteriaBuilder) -> {
            root.fetch(BookEntity_.authors, JoinType.INNER);
            Path<Integer> bookIdPath = root.get(BookEntity_.ID);
            return criteriaBuilder.equal(bookIdPath, bookId);
        };
    }
}
