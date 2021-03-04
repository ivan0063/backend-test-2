package com.walmart.example.api.feedback.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p> User entity, its the object representation for a database table </p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 02/03/2021
 */
@Entity
@Table(name = "USER")
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER")
    private Integer idUser;
    @Column(name = "FULL_NAME")
    private String fullName;
    private String email;
}