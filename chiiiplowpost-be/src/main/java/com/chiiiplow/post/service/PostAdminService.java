package com.chiiiplow.post.service;

import com.chiiiplow.post.components.R;
import com.chiiiplow.post.entity.pojo.PostAdmin;

/**
 * @author CHIIIPLOW
 * @date 2023/09/10
 */
public interface PostAdminService {


    R addPostAdmin(PostAdmin postAdmin);

    R login(PostAdmin postAdmin);

    R checkLogin(PostAdmin postAdmin);
}
