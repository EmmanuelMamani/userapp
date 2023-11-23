package com.userapp.userapp.mapper;
import com.userapp.userapp.dto.User_rolDTO;
import com.userapp.userapp.entity.User_rol;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class User_rolMapper {
    private final ModelMapper modelMapper = new ModelMapper();
    public User_rolDTO entityToDto(User_rol user_rol) {
        return modelMapper.map(user_rol, User_rolDTO.class);
    }

    public User_rol dtoToEntity(User_rolDTO user_rolDTO) {
        return modelMapper.map(user_rolDTO, User_rol.class);
    }
}
