package com.userapp.userapp.dto;

import lombok.Data;

@Data
public class User_rolDTO {
    private Long user_rol_id;
    private Boolean user_rol_active;
    private UserDTO userDTO;
    private RolDTO rolDTO;
}
