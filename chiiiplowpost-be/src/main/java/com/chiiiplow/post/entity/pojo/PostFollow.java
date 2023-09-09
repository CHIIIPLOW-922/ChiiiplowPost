package com.chiiiplow.post.entity.pojo;

import lombok.Data;

/**
 * @author CHIIIPLOW
 * @date 2023/09/10
 */
@Data
public class PostFollow {
    private int followID;
    private int followerID;
    private int followingID;
    private boolean isDeleted;
}
