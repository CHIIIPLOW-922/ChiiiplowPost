package com.chiiiplow.post.entity.pojo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 后台管理员实体类
 * @author CHIIIPLOW
 * @date 2023/09/10
 */
@Data
public class PostAdmin implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Timestamp createdAt;
    private Timestamp lastLogin;
    private boolean isDeleted;
    private String loginFlag;
}
