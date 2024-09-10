package com.magicsoup.bookshell.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Author entity.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "author")
public class AuthorEntity {

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
