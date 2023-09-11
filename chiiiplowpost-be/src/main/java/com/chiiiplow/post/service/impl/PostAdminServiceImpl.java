package com.chiiiplow.post.service.impl;

import com.chiiiplow.post.components.R;
import com.chiiiplow.post.entity.enums.Response;
import com.chiiiplow.post.entity.pojo.PostAdmin;
import com.chiiiplow.post.mapper.PostAdminMapper;
import com.chiiiplow.post.service.PostAdminService;
import com.chiiiplow.post.utils.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author CHIIIPLOW
 * @date 2023/09/10
 */
@Service
public class PostAdminServiceImpl implements PostAdminService {
    @Resource
    PostAdminMapper postAdminMapper;

    @Override
    public R addPostAdmin(PostAdmin postAdmin) {
        String saltPassword = MD5Util.hashPassword(postAdmin.getPassword());
        postAdmin.setPassword(saltPassword);
        int count = postAdminMapper.addAdmin(postAdmin);
        if (count == 1) {
            return R.ok();
        }
        return R.fail(Response.CODE_400);
    }

    @Override
    public R login(PostAdmin postAdmin) {
        String saltPassword = MD5Util.hashPassword(postAdmin.getPassword());
        postAdmin.setPassword(saltPassword);
        PostAdmin admin = postAdminMapper.login(postAdmin);
        if (admin != null) {
            return R.ok();
        }
        return R.fail(Response.CODE_400);
    }


}
