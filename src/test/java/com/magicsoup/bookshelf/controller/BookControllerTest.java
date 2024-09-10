package com.magicsoup.bookshelf.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.magicsoup.bookshelf.config.DefaultSpringBootTest;
import com.magicsoup.bookshelf.model.bean.BookBean;
import com.magicsoup.bookshelf.service.jpa.specification.BookJpaSpecificationService;

@DefaultSpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BookJpaSpecificationService bookJpaSpecificationServiceMocked;

    @Test
    void getAll() throws Exception {

        // mock
        BookBean book = new BookBean("Robinson Crusoe", List.of("Daniel Defoe"));
        doReturn(List.of(book))
                .when(bookJpaSpecificationServiceMocked).getAll();

        // execute
        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.get("/api/book/all"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        // assert && verify
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, BookBean.class);
        List<BookBean> result = objectMapper.readValue(contentAsString, javaType);
        assertThat(result).hasSize(1);
        assertThat(result).containsExactly(book);

        verify(bookJpaSpecificationServiceMocked, times(1)).getAll();
    }
}