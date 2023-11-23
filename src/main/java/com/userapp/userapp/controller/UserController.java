package com.userapp.userapp.controller;
import com.userapp.userapp.dto.UserDTO;
import com.userapp.userapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<UserDTO> getAll(){
        return userService.getUsers();
    }
    @GetMapping("/details")
    public List<UserDTO> getAll_details(){
        return userService.getUserDetails();
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("userId") Long userId) {
        Optional<UserDTO> userDTO = userService.getUser(userId);
        return userDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public void saveUpdate(@Valid @RequestBody UserDTO user){
        userService.saveOrUpdate(user);
    }
    @DeleteMapping("/{userId}")
    public void  delete(@PathVariable("userId") Long userId){
        userService.delete(userId);
    }
}
