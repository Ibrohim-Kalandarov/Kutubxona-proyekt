package org.example.myfirstweb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@NamedQuery(name = "allRent",query = "select r from Rent r")
@NamedQuery(name = "getActiveRent", query = "select r from Rent r where r.active =true")
@NamedQuery(name = "getRent", query = "select r from Rent r where r.id =:id")
@NamedQuery(name = "getRentUserBook" , query = "select r from Rent r where r.book = :book_id and r.user = :user_id")
@NamedQuery(name = "getUserActiveRents", query = "select r from Rent r where r.user = :user and r.active = true")
@NamedQuery(name = "getUserPassiveRents", query = "select r from Rent r where r.user = :user and r.active = false ")
@NamedQuery(name = "getAllRentbyUser",query = "select r from Rent r where r.user = :user")
@NamedQuery(name = "jarimali",query = "select r from Rent r where r.active=false and r.jarima>0.0")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id", unique = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id", unique = false)
    private Book book;
    private final LocalDate from_date = LocalDate.now();
    private LocalDate to_date;
    private boolean active;
    private Double jarima;

}
