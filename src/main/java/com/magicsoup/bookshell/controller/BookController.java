package com.magicsoup.bookshell.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magicsoup.bookshell.model.bean.BookBean;
import com.magicsoup.bookshell.service.jpa.specification.BookJpaSpecificationService;

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
