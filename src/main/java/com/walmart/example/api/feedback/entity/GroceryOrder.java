package com.walmart.example.api.feedback.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p> GroceryOrder entity, its the object representation for a database table </p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 02/03/2021
 */
@Entity
@Table(name = "GROCERY_ORDER")
@Data
public class GroceryOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GROCERY_ORDER")
    private Integer idGroceryOrder;
    @Column(name = "SHIPPING_ADDRESS")
    private String shippingAddress;
    @CreationTimestamp
    @Column(name = "CREATION_DATE")
    private Date creationDat;
    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private User user;
    @ManyToOne
    @JoinColumn(name = "ID_FEEDBACK")
    private Feedback feedback;
    @OneToMany(mappedBy = "groceryOrder")
    private List<GroceryItemOrder> groceryItemOrder;
}
