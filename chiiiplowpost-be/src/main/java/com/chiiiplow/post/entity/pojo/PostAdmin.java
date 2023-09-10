package com.chiiiplow.post.entity.pojo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 后台管理员实体类
 * @author CHIIIPLOW
 * @date 2023/09/10
 */
@Data
public class PostAdmin {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Timestamp createAt;
    private Timestamp lastLogin;
    private boolean isDeleted;
}
