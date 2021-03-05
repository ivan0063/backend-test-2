package com.walmart.example.api.feedback.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p> GroceryItemOrder entity, its the object representation for a database table </p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 05/03/2021
 */
@Entity
@Table(name = "GROCERY_ITEM_ORDER")
@Data
public class GroceryItemOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GROCERY_ITEM_ORDER")
    private Integer idGroceryItemOrder;
    @ManyToOne
    @JoinColumn(name = "ID_GROCERY_ITEM")
    private GroceryItem groceryItem;
    @ManyToOne
    @JoinColumn(name = "ID_GROCERY_ORDER")
    private GroceryOrder groceryOrder;
}
