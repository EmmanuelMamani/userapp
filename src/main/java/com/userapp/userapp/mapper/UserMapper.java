package com.userapp.userapp.mapper;
import com.userapp.userapp.dto.UserDTO;
import com.userapp.userapp.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public UserDTO entityToDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User dtoToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}

