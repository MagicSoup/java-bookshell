package com.magicsoup.bookshell.service.jpa.criteria;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.magicsoup.bookshell.mapper.BookMapper;
import com.magicsoup.bookshell.model.bean.BookBean;
import com.magicsoup.bookshell.model.bean.TemporalGrouping;
import com.magicsoup.bookshell.model.entity.BookEntity;
import com.magicsoup.bookshell.repository.jpa.critera.BookJpaCriteriaRepository;
import com.magicsoup.bookshell.service.IBookService;

/**
 * JPA Criteria service implementation to find books
 */
@RequiredArgsConstructor
@Service
public class BookJpaCriteriaService implements IBookService {

    private final BookJpaCriteriaRepository bookJpaCriteriaRepository;

    public Map<String, Long> countBookGroupByPublishedAt(TemporalGrouping groupingBy) {
        return bookJpaCriteriaRepository.countBookGroupByPublishedAt(groupingBy);
    }

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

