package com.magicsoup.spring.data.service.jpa.specification;

import java.util.List;
import java.util.Optional;

import jakarta.annotation.Nullable;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.magicsoup.spring.data.mapper.BookMapper;
import com.magicsoup.spring.data.model.bean.BookBean;
import com.magicsoup.spring.data.model.entity.BookEntity;
import com.magicsoup.spring.data.repository.jpa.specification.BookJpaSpecification;
import com.magicsoup.spring.data.repository.jpa.specification.BookJpaSpecificationRepository;
import com.magicsoup.spring.data.service.IBookService;

/**
 * JPA Specification service implementation to find books
 */
@RequiredArgsConstructor
@Service
public class BookJpaSpecificationService implements IBookService {

    private final BookJpaSpecificationRepository bookJpaSpecificationRepository;

    @Nullable
    public BookBean findByBookId(Integer bookId) {

        Optional<BookEntity> book = bookJpaSpecificationRepository.findOne(BookJpaSpecification.byBookId(bookId));

        return book.map(BookMapper.INSTANCE::mapBook).orElse(null);
    }

    public List<BookBean> findByAuthorId(Integer authorId) {

        List<BookEntity> books = bookJpaSpecificationRepository.findAll(BookJpaSpecification.byAuthorId(authorId));

        return BookMapper.INSTANCE.mapBookList(books);
    }
}

