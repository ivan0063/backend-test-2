package com.walmart.example.api.feedback.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GROCERY_ORDER")
@Data
public class GroceryOrder implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ID_GROCERY_ORDER")
    private Integer idGroceryOrder;
    @Column(name = "SHIPPING_ADDRESS")
    private String shippingAddress;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_feedback")
    private Feedback feedback;
}
