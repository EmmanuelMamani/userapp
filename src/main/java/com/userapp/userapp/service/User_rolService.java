package com.userapp.userapp.service;

import com.userapp.userapp.dto.User_rolDTO;
import com.userapp.userapp.entity.Rol;
import com.userapp.userapp.entity.User;
import com.userapp.userapp.entity.User_rol;
import com.userapp.userapp.mapper.User_rolMapper;
import com.userapp.userapp.repository.RolRepository;
import com.userapp.userapp.repository.UserRepository;
import com.userapp.userapp.repository.User_rolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class User_rolService {

    private final User_rolRepository user_rolRepository;
    private final UserRepository userRepository;
    private final RolRepository rolRepository;
    private final User_rolMapper user_rolMapper;

    @Autowired
    public User_rolService(User_rolRepository user_rolRepository, User_rolMapper user_rolMapper,UserRepository userRepository,RolRepository rolRepository) {
        this.user_rolRepository = user_rolRepository;
        this.user_rolMapper = user_rolMapper;
        this.userRepository = userRepository;
        this.rolRepository = rolRepository;
    }

    public List<User_rolDTO> getUser_roles() {
        List<User_rol> user_roles = user_rolRepository.findAll();
        return user_roles.stream()
                .map(user_rolMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public Optional<User_rolDTO> getUser_rol(Long id) {
        Optional<User_rol> user_rol = user_rolRepository.findById(id);
        return user_rol.map(user_rolMapper::entityToDto);
    }

    public void saveOrUpdate(User_rolDTO userRolDTO) {
        User_rol user_rol = user_rolMapper.dtoToEntity(userRolDTO);
        user_rolRepository.save(user_rol);
    }

    public void delete(Long id) {
        user_rolRepository.deleteById(id);
    }

    public void assignRolesToUser(Long userId, List<Long> roleIds) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            List<Rol> roles = rolRepository.findAllById(roleIds);
            for (Rol rol : roles) {
                User_rol user_rol = new User_rol();
                user_rol.setUser(user);
                user_rol.setRol(rol);
                user_rolRepository.save(user_rol);
            }
        }
    }
    public void dump(Long user_rolId) {
        Optional<User_rol> user_rol = user_rolRepository.findById(user_rolId);
        if (user_rol.isPresent()) {
            User_rol user_rol1 = user_rol.get();
            user_rol1.setUser_rol_active(false);
            user_rolRepository.save(user_rol1);
        } else {
            throw new NoSuchElementException("User_rol no encontrado con ID: " + user_rolId);
        }
    }
}
