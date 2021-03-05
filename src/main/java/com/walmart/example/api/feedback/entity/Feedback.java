package com.walmart.example.api.feedback.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <p> Feedback entity, its the object representation for a database table </p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 02/03/2021
 */
@Entity
@Table(name = "FEEDBACK")
@Data
public class Feedback implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FEEDBACK")
    private Integer idFeedback;
    private Integer rate;
    private String comment;
    @CreationTimestamp
    private Date created;
    @Column(name = "FLAG_ITEM")
    private Boolean flagItem;
}