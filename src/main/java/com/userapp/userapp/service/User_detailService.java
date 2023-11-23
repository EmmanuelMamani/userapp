package com.userapp.userapp.service;

import com.userapp.userapp.dto.User_detailDTO;
import com.userapp.userapp.entity.User_detail;
import com.userapp.userapp.mapper.User_detailMapper;
import com.userapp.userapp.repository.User_detailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class User_detailService {

    private final User_detailRepository user_detailRepository;
    private final User_detailMapper user_detailMapper;

    @Autowired
    public User_detailService(User_detailRepository user_detailRepository, User_detailMapper user_detailMapper) {
        this.user_detailRepository = user_detailRepository;
        this.user_detailMapper = user_detailMapper;
    }

    public List<User_detailDTO> getUser_details() {
        List<User_detail> user_details = user_detailRepository.findAll();
        return user_details.stream()
                .map(user_detailMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public Optional<User_detailDTO> getUser_detail(Long id) {
        Optional<User_detail> user_detail = user_detailRepository.findById(id);
        return user_detail.map(user_detailMapper::entityToDto);
    }

    public void saveOrUpdate(User_detailDTO user_detailDTO) {
        User_detail user_detail = user_detailMapper.dtoToEntity(user_detailDTO);
        user_detailRepository.save(user_detail);
    }

    public void delete(Long id) {
        user_detailRepository.deleteById(id);
    }
}
