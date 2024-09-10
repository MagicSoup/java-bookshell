package com.magicsoup.bookshell.service.jpa.specification;

import java.util.List;
import java.util.Optional;

import jakarta.annotation.Nullable;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.magicsoup.bookshell.mapper.BookMapper;
import com.magicsoup.bookshell.model.bean.BookBean;
import com.magicsoup.bookshell.model.entity.BookEntity;
import com.magicsoup.bookshell.repository.jpa.specification.BookJpaSpecification;
import com.magicsoup.bookshell.repository.jpa.specification.BookJpaSpecificationRepository;
import com.magicsoup.bookshell.service.IBookService;

/**
 * JPA Specification service implementation to find books
 */
@RequiredArgsConstructor
@Service
public class BookJpaSpecificationService implements IBookService {

    private final BookJpaSpecificationRepository bookJpaSpecificationRepository;

    @Nullable
    public List<BookBean> getAll() {
        Iterable<BookEntity> books = bookJpaSpecificationRepository.findAll();
        return BookMapper.INSTANCE.mapBookList(books);
    }

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

