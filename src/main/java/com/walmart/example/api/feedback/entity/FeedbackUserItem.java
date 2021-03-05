package com.walmart.example.api.feedback.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p> FeedbackUserItem entity, its the object representation for a database table </p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 05/03/2021
 */
@Entity
@Table(name = "FEEDBACK_USER_ITEM")
@Data
public class FeedbackUserItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FEEDBACK_USER_ITEM")
    private Integer idFeedbackUserItem;
    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private User user;
    @ManyToOne
    @JoinColumn(name = "ID_FEEDBACK")
    private Feedback feedback;
    @ManyToOne
    @JoinColumn(name = "ID_GROCERY_ITEM")
    private GroceryItem groceryItem;
}
