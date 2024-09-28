package org.example.myfirstweb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Buy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id", unique = false)
    private User user;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "book_id", unique = false)
    private Book book;
    private final LocalDate buyDate = LocalDate.now();
}
