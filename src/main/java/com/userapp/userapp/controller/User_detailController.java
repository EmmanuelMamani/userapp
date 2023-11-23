package com.userapp.userapp.controller;
import com.userapp.userapp.dto.UserDTO;
import com.userapp.userapp.dto.User_detailDTO;
import com.userapp.userapp.entity.User_detail;
import com.userapp.userapp.service.User_detailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/user_details")
public class User_detailController {
    @Autowired
    private User_detailService user_detailService;
    @GetMapping
    public List<User_detailDTO> getAll(){
        return user_detailService.getUser_details();
    }
    @GetMapping("/{user_detailId}")
    public ResponseEntity<User_detailDTO> getUser(@PathVariable("user_detailId") Long user_detailId) {
        Optional<User_detailDTO> user_detailDTO = user_detailService.getUser_detail(user_detailId);
        return user_detailDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public void saveUpdate(@RequestBody User_detailDTO user_detailDTO){
        user_detailService.saveOrUpdate(user_detailDTO);
    }
    @DeleteMapping("/{user_detailId}")
    public void  delete(@PathVariable("user_detailId") Long user_detailId){
        user_detailService.delete(user_detailId);
    }
}
