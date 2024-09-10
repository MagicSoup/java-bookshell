package com.magicsoup.spring.data.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.AliasFor;
import org.springframework.test.context.ActiveProfiles;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest
@ActiveProfiles
public @interface DefaultSpringBootTest {

    @AliasFor(annotation = ActiveProfiles.class)
    String[] profiles() default {"test"};

    @AliasFor(annotation = SpringBootTest.class)
    SpringBootTest.WebEnvironment webEnvironment() default SpringBootTest.WebEnvironment.MOCK;
}
