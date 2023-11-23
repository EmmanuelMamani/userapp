package com.userapp.userapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rol_id;
    private String rol_name;
    @OneToMany(mappedBy = "rol")
    private List<User_rol> userRoles = new ArrayList<>();
}
