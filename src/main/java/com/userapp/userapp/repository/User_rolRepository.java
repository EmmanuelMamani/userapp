package com.userapp.userapp.repository;
import com.userapp.userapp.entity.User_rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_rolRepository extends JpaRepository<User_rol,Long> {
}
