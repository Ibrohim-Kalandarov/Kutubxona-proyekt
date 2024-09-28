package org.example.myfirstweb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "allBook", query = "select b from Book b")
@NamedQuery(name = "byTitleBook", query = "select b from Book b where b.title = :title ")
@NamedQuery(name = "byAuthorBook", query = "select b from Book b where b.author = :author ")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String isbn;
    @Column(nullable = false)
    private String publisher;
    @Column(nullable = false)
    private Integer quantity;
    private Double price;
    private String img;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}
