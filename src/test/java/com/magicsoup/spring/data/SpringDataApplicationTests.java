package com.magicsoup.spring.data;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.magicsoup.spring.data.config.DefaultSpringBootTest;

@DefaultSpringBootTest
class SpringDataApplicationTests {

    @Autowired
    private Environment env;

    @Test
    void contextLoads() {
        assertThat(env).isNotNull();
    }

}
