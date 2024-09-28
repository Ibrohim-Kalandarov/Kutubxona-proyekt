package org.example.myfirstweb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.myfirstweb.enums.CategoryName;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@NamedQuery(name = "getAllCategory",query = "select c from Category c")
@NamedQuery(name = "getCategorybyId",query = "select c from Category c where c.id = :id" )
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryName name;
}
