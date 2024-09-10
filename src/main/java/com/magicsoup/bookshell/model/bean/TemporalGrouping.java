package com.magicsoup.bookshell.model.bean;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TemporalGrouping {

    YEAR("yyyy"),
    MONTH("MM-yyyy"),
    DAY("dd-MM-yyyy");

    private final String pattern;
}
