package cn.edu.tongji.easygo.dto;

import lombok.Data;

@Data
public class UserLoginDTO {
    private Long userId;
    private String userName;
    private String userAvatar;
    private Integer userRole;
    private String result;
    private String token;
}
