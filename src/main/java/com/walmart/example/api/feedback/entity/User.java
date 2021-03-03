package com.walmart.example.api.feedback.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USER")
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ID_USER")
    private Integer idUser;
    @Column(name = "FULL_NAME")
    private String fullName;
    private String email;
}