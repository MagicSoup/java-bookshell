package com.magicsoup.spring.data.mapper;

import java.util.List;

import com.magicsoup.spring.data.model.bean.BookBean;
import com.magicsoup.spring.data.model.entity.AuthorEntity;
import com.magicsoup.spring.data.model.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    List<BookBean> mapBookList(List<BookEntity> books);

    BookBean mapBook(BookEntity book);

    default String mapAuthor(AuthorEntity author) {
        return "%s %s".formatted(author.getFirstName(), author.getLastName());
    }
}
