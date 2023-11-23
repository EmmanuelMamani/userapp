package com.userapp.userapp.service;

import com.userapp.userapp.dto.UserDTO;
import com.userapp.userapp.dto.User_detailDTO;
import com.userapp.userapp.entity.User;
import com.userapp.userapp.mapper.UserMapper;
import com.userapp.userapp.mapper.User_detailMapper;
import com.userapp.userapp.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final User_detailMapper user_detailMapper;
    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper,User_detailMapper user_detailMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.user_detailMapper = user_detailMapper;
    }

    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public List<UserDTO> getUserDetails() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> {
                    UserDTO userDTO = userMapper.entityToDto(user);
                    User_detailDTO user_detailDTO = user_detailMapper.entityToDto(user.getUser_details());
                    userDTO.setUserDetail(user_detailDTO);
                    return userDTO;
                })
                .collect(Collectors.toList());
    }

    public Optional<UserDTO> getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(userMapper::entityToDto);
    }
    @Transactional
    public void saveOrUpdate(UserDTO userDTO) {
        User user = userMapper.dtoToEntity(userDTO);
        userRepository.save(user);
    }
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
