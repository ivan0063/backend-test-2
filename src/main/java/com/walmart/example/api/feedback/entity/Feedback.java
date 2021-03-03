package com.walmart.example.api.feedback.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "FEEDBACK")
@Data
public class Feedback implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ID_FEEDBACK")
    private Integer idFeedback;
    private Integer rate;
    private String comment;
    private Timestamp created;
}
