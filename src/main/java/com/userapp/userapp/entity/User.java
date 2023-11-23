package com.userapp.userapp.entity;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.ArrayList;

@Data
@Entity
@Table(name = "Users")
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @NotNull(message = "El campo username no puede ser nulo")
    private String username;
    @Size(min = 8, max = 20, message = "La contraseña debe tener entre 8 y 20 caracteres")
    private String password;
    @Email(message = "Debe ser una dirección de correo electrónico válida")
    private String email;
    @OneToMany(mappedBy = "user")
    private List<User_rol> userRoles = new ArrayList<>();
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private User_detail User_details;
}
