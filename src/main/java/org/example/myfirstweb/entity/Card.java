package org.example.myfirstweb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.myfirstweb.enums.CardType;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@NamedQuery(name = "findCard",query = "select c from Card c where c.user = :user")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Double balance;
    private String cardNumber;
    private String cardName;
    private CardType cardType;
    @ManyToOne
    private User user;
}
