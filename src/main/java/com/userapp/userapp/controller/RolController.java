package com.userapp.userapp.controller;

import com.userapp.userapp.dto.RolDTO;
import com.userapp.userapp.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/roles")
public class RolController {
    @Autowired
    private RolService rolService;
    @GetMapping
    public List<RolDTO> getAll(){
        return rolService.getRoles();
    }
    @GetMapping("/{rolId}")
    public ResponseEntity<RolDTO> getUser(@PathVariable("rolId") Long rolId) {
        Optional<RolDTO> rolDTO = rolService.getRol(rolId);
        return rolDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public void saveUpdate(@RequestBody RolDTO rolDTO){
        rolService.saveOrUpdate(rolDTO);
    }
    @DeleteMapping("{rolId}")
    public void  delete(@PathVariable("rolId") Long rolId){
        rolService.delete(rolId);
    }
}
