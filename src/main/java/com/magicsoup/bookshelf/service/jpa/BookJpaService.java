package com.magicsoup.bookshelf.service.jpa;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.magicsoup.bookshelf.mapper.BookMapper;
import com.magicsoup.bookshelf.model.bean.BookBean;
import com.magicsoup.bookshelf.model.entity.BookEntity;
import com.magicsoup.bookshelf.repository.jpa.BookJpaRepository;
import com.magicsoup.bookshelf.service.IBookService;

/**
 * JPA service implementation to find books
 */
@RequiredArgsConstructor
@Service
public class BookJpaService implements IBookService {

    private final BookJpaRepository bookJpaRepository;

    @Nullable
    public BookBean findByBookId(Integer bookId) {

        BookEntity book = bookJpaRepository.findByBookId(bookId);

        return Optional.ofNullable(book)
                .map(BookMapper.INSTANCE::mapBook)
                .orElse(null);
    }

    public List<BookBean> findByAuthorId(Integer authorId) {

        List<BookEntity> books = bookJpaRepository.findByAuthorId(authorId);

        return BookMapper.INSTANCE.mapBookList(books);
    }
}

