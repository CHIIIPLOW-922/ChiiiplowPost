package com.chiiiplow.post.entity.pojo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 帖子实体类
 * @author CHIIIPLOW
 * @date 2023/09/10
 */
@Data
public class Post {
    private int postID;
    private int userID;
    private String content;
    private String media;
    private Timestamp createdAt;
    private boolean isDeleted;
    private Timestamp lastUpdated;
}
