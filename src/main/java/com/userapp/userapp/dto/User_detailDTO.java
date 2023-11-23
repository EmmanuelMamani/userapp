package com.userapp.userapp.dto;

import lombok.Data;
import java.util.Date;

@Data
public class User_detailDTO {
    private Long user_detail_id;
    private String first_name;
    private String last_mane;
    private Integer age;
    private Date birth_day;
    private Long user_id;
}
