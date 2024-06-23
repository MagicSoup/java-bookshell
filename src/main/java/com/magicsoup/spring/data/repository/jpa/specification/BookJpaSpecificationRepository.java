package com.magicsoup.spring.data.repository.jpa.specification;

import com.magicsoup.spring.data.model.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * JPA Specification repository implementation to find books
 */
public interface BookJpaSpecificationRepository extends CrudRepository<BookEntity, Integer>, JpaSpecificationExecutor<BookEntity> {

}
