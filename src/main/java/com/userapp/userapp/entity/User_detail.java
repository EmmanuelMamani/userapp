package com.userapp.userapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="User_detail")
public class User_detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_detail_id;
    private String first_name;
    private String last_mane;
    private Integer age;
    private Date birth_day;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
