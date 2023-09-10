package com.chiiiplow.post.entity.pojo;

import lombok.Data;

/**
 * 点赞实体类
 * @author CHIIIPLOW
 * @date 2023/09/10
 */
@Data
public class PostLike {
    private int likeID;
    private int postID;
    private int userID;
    private boolean isDeleted;
}
