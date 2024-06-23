package com.magicsoup.spring.data.service;

import java.util.List;

import com.magicsoup.spring.data.model.bean.BookBean;
import org.springframework.lang.Nullable;

/**
 * Service to find books.
 */
public interface IBookService {

    /**
     * Find book by book bookId
     *
     * @param bookId the book bookId
     * @return the found book, can be null
     */
    @Nullable
    BookBean findByBookId(Integer bookId);

    /**
     * Find book by author id
     *
     * @param authorId the author id
     * @return the list of found books
     */
    List<BookBean> findByAuthorId(Integer authorId);
}
