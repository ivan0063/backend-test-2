package com.walmart.example.api.feedback.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p> GroceryItem entity, its the object representation for a database table </p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 05/03/2021
 */
@Entity
@Table(name = "GROCERY_ITEM")
@Data
public class GroceryItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GROCERY_ITEM")
    private Integer idGroceryItem;
    @Column(name = "ITEM_NAME")
    private String itemName;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "ID_FEEDBACK")
    private Feedback feedback;
}
