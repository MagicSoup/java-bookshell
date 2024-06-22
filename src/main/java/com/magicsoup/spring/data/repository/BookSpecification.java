package com.magicsoup.spring.data.repository;

import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Path;

import com.magicsoup.spring.data.model.entity.AuthorEntity_;
import com.magicsoup.spring.data.model.entity.BookEntity;
import com.magicsoup.spring.data.model.entity.BookEntity_;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {

    public static Specification<BookEntity> byAuthorId(Integer authorId) {
        return (root, query, criteriaBuilder) -> {
            root.fetch(BookEntity_.authors, JoinType.INNER);
            Path<Integer> authorIdPath = root.get(BookEntity_.AUTHORS).get(AuthorEntity_.ID);
            return criteriaBuilder.equal(authorIdPath, authorId);
        };
    }

    public static Specification<BookEntity> byId(Integer id) {
        return (root, query, criteriaBuilder) -> {
            root.fetch(BookEntity_.authors, JoinType.INNER);
            Path<Integer> bookIdPath = root.get(BookEntity_.ID);
            return criteriaBuilder.equal(bookIdPath, id);
        };
    }
}
