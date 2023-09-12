package com.chiiiplow.post.entity.pojo;

import lombok.Data;

import java.sql.Timestamp;


/**
 * 帖子用户实体类
 * @author CHIIIPLOW
 * @date 2023/09/10
 */
@Data
public class PostUser {
    private int userID;
    private String username;
    private String email;
    private String passwordHash;
    private String avatar;
    private Timestamp createdAt;
    private boolean isDeleted;
    private Timestamp lastUpdated;
    private String loginFlag;
}
