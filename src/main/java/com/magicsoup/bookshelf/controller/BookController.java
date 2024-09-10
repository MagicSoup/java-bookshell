package com.magicsoup.bookshelf.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magicsoup.bookshelf.model.bean.BookBean;
import com.magicsoup.bookshelf.service.jpa.specification.BookJpaSpecificationService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookJpaSpecificationService bookJpaSpecificationService;

    @GetMapping("/all")
    public List<BookBean> getAll() {
        return bookJpaSpecificationService.getAll();
    }
}
