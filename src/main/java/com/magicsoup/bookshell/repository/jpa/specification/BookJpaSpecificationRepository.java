package com.magicsoup.bookshell.repository.jpa.specification;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.magicsoup.bookshell.model.entity.BookEntity;

/**
 * JPA Specification repository implementation to find books
 */
public interface BookJpaSpecificationRepository extends CrudRepository<BookEntity, Integer>, JpaSpecificationExecutor<BookEntity> {

}
