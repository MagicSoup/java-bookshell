package com.magicsoup.spring.data.repository.jpa.critera;

import com.magicsoup.spring.data.model.entity.AuthorEntity;
import com.magicsoup.spring.data.model.entity.AuthorEntity_;
import com.magicsoup.spring.data.model.entity.BookEntity;
import com.magicsoup.spring.data.model.entity.BookEntity_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * JPA critera implementation to find books
 */
@RequiredArgsConstructor
@Repository
public class BookJpaCriteriaRepository {

    private final EntityManager entityManager;

    @Nullable
    public Map<String, Long> countBookGroupByPublishedAt(ChronoField chronoField) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);

        Root<BookEntity> root = criteriaQuery.from(BookEntity.class);

        Expression<String> timeExpression = buildTimeExpressionByChronoField(criteriaBuilder, root);
        criteriaQuery.multiselect(timeExpression, criteriaBuilder.count(root.get(BookEntity_.ID)));
        criteriaQuery.groupBy(timeExpression);

        String format = switch (chronoField) {
            case YEAR -> "yyyy";
            case MONTH_OF_YEAR -> "MM-yyyy";
            case DAY_OF_MONTH -> "dd-MM-yyyy";
            default -> throw new IllegalStateException("Unexpected value: " + chronoField);
        };

        List<Tuple> resultList = entityManager.createQuery(criteriaQuery)
                .setParameter("timeParameter", format)
                .getResultList();

        return resultList.stream().collect(Collectors.toMap(
                (Tuple tuple) -> tuple.get(0, String.class),
                (Tuple tuple) -> tuple.get(1, Long.class)
        ));
    }

    Expression<String> buildTimeExpressionByChronoField(CriteriaBuilder criteriaBuilder, Root<BookEntity> root) {
        return criteriaBuilder.function("to_char", String.class, root.get(BookEntity_.PUBLISHED_AT),
                criteriaBuilder.parameter(String.class, "timeParameter"));
    }

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
