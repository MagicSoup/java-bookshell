package com.magicsoup.bookshelf.model.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Book entity.
 */
@NoArgsConstructor
@AllArgsConstructor
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

