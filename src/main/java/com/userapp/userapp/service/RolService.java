package com.userapp.userapp.service;

import com.userapp.userapp.dto.RolDTO;
import com.userapp.userapp.entity.Rol;
import com.userapp.userapp.mapper.RolMapper;
import com.userapp.userapp.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolService {

    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    @Autowired
    public RolService(RolRepository rolRepository, RolMapper rolMapper) {
        this.rolRepository = rolRepository;
        this.rolMapper = rolMapper;
    }

    public List<RolDTO> getRoles() {
        List<Rol> roles = rolRepository.findAll();
        return roles.stream()
                .map(rolMapper::entityToDto)
                .collect(Collectors.toList());
    }
    public Optional<RolDTO> getRol(Long id) {
        Optional<Rol> rol = rolRepository.findById(id);
        return rol.map(rolMapper::entityToDto);
    }
    public void saveOrUpdate(RolDTO rolDTO) {
        Rol rol = rolMapper.dtoToEntity(rolDTO);
        rolRepository.save(rol);
    }

    public void delete(Long id) {
        rolRepository.deleteById(id);
    }
}
