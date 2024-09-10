package com.magicsoup.bookshelf.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.magicsoup.bookshelf.model.bean.BookBean;
import com.magicsoup.bookshelf.model.entity.AuthorEntity;
import com.magicsoup.bookshelf.model.entity.BookEntity;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    List<BookBean> mapBookList(Iterable<BookEntity> books);

    BookBean mapBook(BookEntity book);

    default String mapAuthor(AuthorEntity author) {
        return "%s %s".formatted(author.getFirstName(), author.getLastName());
    }
}
