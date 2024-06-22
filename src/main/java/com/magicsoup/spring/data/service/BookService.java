package com.magicsoup.spring.data.service;

import jakarta.annotation.Nullable;

import java.util.List;
import java.util.Optional;

import com.magicsoup.spring.data.mapper.BookMapper;
import com.magicsoup.spring.data.model.bean.BookBean;
import com.magicsoup.spring.data.model.entity.BookEntity;
import com.magicsoup.spring.data.repository.BookRepository;
import com.magicsoup.spring.data.repository.BookSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    @Nullable
    public BookBean findById(Integer id) {

        Optional<BookEntity> book = bookRepository.findOne(BookSpecification.byId(id));

        return book.map(BookMapper.INSTANCE::mapBook).orElse(null);
    }

    public List<BookBean> findByAuthorId(Integer authorId) {

        List<BookEntity> books = bookRepository.findAll(BookSpecification.byAuthorId(authorId));

        return BookMapper.INSTANCE.mapBookList(books);
    }
}

