package com.magicsoup.spring.data.model.bean;

import java.util.List;

import lombok.Data;

@Data
public class BookBean {

    private String title;
    private List<String> authors;
}
