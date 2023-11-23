package com.userapp.userapp.repository;
import com.userapp.userapp.entity.User_detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_detailRepository extends JpaRepository<User_detail,Long> {
}
