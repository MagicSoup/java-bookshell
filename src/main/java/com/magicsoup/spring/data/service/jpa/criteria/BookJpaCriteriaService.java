package com.magicsoup.spring.data.service.jpa.criteria;

import java.util.List;
import java.util.Optional;

import com.magicsoup.spring.data.mapper.BookMapper;
import com.magicsoup.spring.data.model.bean.BookBean;
import com.magicsoup.spring.data.model.entity.BookEntity;
import com.magicsoup.spring.data.repository.jpa.critera.BookJpaCriteriaRepository;
import com.magicsoup.spring.data.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

/**
 * JPA Criteria service implementation to find books
 */
@RequiredArgsConstructor
@Service
public class BookJpaCriteriaService implements IBookService {

    private final BookJpaCriteriaRepository bookJpaCriteriaRepository;

    @Nullable
    public BookBean findByBookId(Integer bookId) {

        BookEntity book = bookJpaCriteriaRepository.findByBookId(bookId);

        return Optional.ofNullable(book)
                .map(BookMapper.INSTANCE::mapBook)
                .orElse(null);
    }

    public List<BookBean> findByAuthorId(Integer authorId) {

        List<BookEntity> books = bookJpaCriteriaRepository.findByAuthorId(authorId);

        return BookMapper.INSTANCE.mapBookList(books);
    }
}

