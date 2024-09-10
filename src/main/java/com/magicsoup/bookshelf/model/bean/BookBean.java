package com.magicsoup.bookshelf.model.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookBean {

    private String title;
    private List<String> authors;
}
