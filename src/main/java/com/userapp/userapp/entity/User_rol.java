package com.userapp.userapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="User_rol")
public class User_rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_rol_id;
    private Boolean user_rol_active;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;
}
