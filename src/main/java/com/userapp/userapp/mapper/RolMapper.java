package com.userapp.userapp.mapper;
import com.userapp.userapp.dto.RolDTO;
import com.userapp.userapp.entity.Rol;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
public class RolMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public RolDTO entityToDto(Rol rol) {
        return modelMapper.map(rol, RolDTO.class);
    }

    public Rol dtoToEntity(RolDTO rolDTO) {
        return modelMapper.map(rolDTO, Rol.class);
    }
}


