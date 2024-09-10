package com.magicsoup.spring.data.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import org.springframework.cglib.core.Local;

/**
 * The type Book entity.
 */
@Data
@Entity
@Table(name = "book")
public class BookEntity {

    /**
     * Uuid string.
     *
     * @return the string
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * Title string.
     *
     * @return the string
     */
    @Column(name = "title")
    private String title;

    /**
     * Authors list.
     *
     * @return the list
     */
    @ManyToMany(targetEntity = AuthorEntity.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
    private List<AuthorEntity> authors;

    @Column(name = "published_at")
    @Temporal(TemporalType.DATE)
    private LocalDate publishedAt;

}

