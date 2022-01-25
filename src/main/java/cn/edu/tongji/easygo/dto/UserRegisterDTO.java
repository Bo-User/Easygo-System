package cn.edu.tongji.easygo.dto;

import lombok.Data;

@Data
public class UserRegisterDTO {
    private Long userId;
    private String userName;
    private String userPassword;
    private String userPhonenumber;
}
