package com.userapp.userapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
    private Long user_id;
    @NotNull(message = "El campo username no puede ser nulo")
    private String username;
    @Size(min = 8, max = 20, message = "La contraseña debe tener entre 8 y 20 caracteres")
    private String password;
    @Email(message = "Debe ser una dirección de correo electrónico válida")
    private String email;
    private User_detailDTO userDetail;
}
