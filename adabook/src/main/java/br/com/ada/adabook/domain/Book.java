package br.com.ada.adabook.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Book {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Integer publicationYear;
    private Integer numberPages;
    private String isbn;

    @ManyToMany
    @JoinTable(name = "book_author",
    joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;
    @CreationTimestamp
    @Column(columnDefinition = "datetime")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(columnDefinition = "datetime")
    private LocalDateTime updatedAt;



}
