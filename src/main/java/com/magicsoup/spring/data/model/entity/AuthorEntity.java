package com.magicsoup.spring.data.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

/**
 * The type Author entity.
 */
@Data
@Entity
@Table(name = "author")
public abstract class AuthorEntity {

    /**
     * Uuid string.
     *
     * @return the string
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    /**
     * First name string.
     *
     * @return the string
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * Last name string.
     *
     * @return the string
     */
    @Column(name = "last_name")
    private String lastName;
}
