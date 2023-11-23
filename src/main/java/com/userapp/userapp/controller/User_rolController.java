package com.userapp.userapp.controller;

import com.userapp.userapp.dto.UserDTO;
import com.userapp.userapp.dto.User_rolDTO;
import com.userapp.userapp.entity.User_rol;
import com.userapp.userapp.service.User_rolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/user_roles")
public class User_rolController {
    @Autowired
    private User_rolService user_rolService;
    @GetMapping
    public List<User_rolDTO> getAll(){
        return user_rolService.getUser_roles();
    }
    @GetMapping("/{user_rolId}")
    public ResponseEntity<User_rolDTO> getUser(@PathVariable("user_rolId") Long user_rolId) {
        Optional<User_rolDTO> user_rolDTO = user_rolService.getUser_rol(user_rolId);
        return user_rolDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public void saveUpdate(@RequestBody User_rolDTO user_rolDTO){
        user_rolService.saveOrUpdate(user_rolDTO);
    }

    @PostMapping("/assign_roles/{userId}")
    public ResponseEntity<String> assignRolesToUser(@PathVariable("userId") Long userId, @RequestBody List<Long> roleIds) {
        try {
            user_rolService.assignRolesToUser(userId, roleIds);
            return new ResponseEntity<>("Rol asignado Correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al asignar el rol", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("{user_rolId}")
    public void  delete(@PathVariable("user_rolId") Long user_rolId){
        user_rolService.delete(user_rolId);
    }
    @PatchMapping("/{user_rolId}")
    public ResponseEntity<String> dump(@PathVariable("user_rolId") Long user_rolId) {
        try {
            user_rolService.dump(user_rolId);
            return ResponseEntity.ok("Rol_usuario con ID " + user_rolId + " desactivado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al desactivar el Rol_usuario");
        }
    }
}
