package com.magicsoup.bookshell.service.jpa;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.magicsoup.bookshell.mapper.BookMapper;
import com.magicsoup.bookshell.model.bean.BookBean;
import com.magicsoup.bookshell.model.entity.BookEntity;
import com.magicsoup.bookshell.repository.jpa.BookJpaRepository;
import com.magicsoup.bookshell.service.IBookService;

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

