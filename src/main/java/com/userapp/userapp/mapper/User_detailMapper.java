package com.userapp.userapp.mapper;
import com.userapp.userapp.dto.User_detailDTO;
import com.userapp.userapp.entity.User_detail;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class User_detailMapper {
    private final ModelMapper modelMapper = new ModelMapper();
    public User_detailDTO entityToDto(User_detail user_detail) {
        return modelMapper.map(user_detail, User_detailDTO.class);
    }

    public User_detail dtoToEntity(User_detailDTO user_detailDTO) {
        return modelMapper.map(user_detailDTO, User_detail.class);
    }
}
