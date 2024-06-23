package com.magicsoup.spring.data.repository.jpa.critera;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Fetch;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;

import java.util.List;

import com.magicsoup.spring.data.model.entity.AuthorEntity;
import com.magicsoup.spring.data.model.entity.AuthorEntity_;
import com.magicsoup.spring.data.model.entity.BookEntity;
import com.magicsoup.spring.data.model.entity.BookEntity_;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

/**
 * JPA critera implementation to find books
 */
@RequiredArgsConstructor
@Repository
public class BookJpaCriteriaRepository {

    private final EntityManager entityManager;
    
    @Nullable
    public BookEntity findByBookId(Integer bookId) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BookEntity> criteriaQuery = criteriaBuilder.createQuery(BookEntity.class);

        Root<BookEntity> root = criteriaQuery.from(BookEntity.class);

        root.fetch(BookEntity_.authors, JoinType.INNER);
        criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.equal(root.get(BookEntity_.ID), bookId)));

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public List<BookEntity> findByAuthorId(Integer authorId) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BookEntity> criteriaQuery = criteriaBuilder.createQuery(BookEntity.class);

        Root<BookEntity> root = criteriaQuery.from(BookEntity.class);

        Fetch<BookEntity, AuthorEntity> authorInnerJoinFetch = root.fetch(BookEntity_.authors, JoinType.INNER);
        Path<Integer> authorIdPath = ((Join<BookEntity, AuthorEntity>) authorInnerJoinFetch).get(AuthorEntity_.ID);
        criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.equal(authorIdPath, authorId)));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
