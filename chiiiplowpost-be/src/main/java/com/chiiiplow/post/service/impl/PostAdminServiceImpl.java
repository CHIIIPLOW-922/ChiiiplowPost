package com.chiiiplow.post.service.impl;

import com.chiiiplow.post.components.R;
import com.chiiiplow.post.entity.enums.Response;
import com.chiiiplow.post.entity.pojo.PostAdmin;
import com.chiiiplow.post.mapper.PostAdminMapper;
import com.chiiiplow.post.service.PostAdminService;
import com.chiiiplow.post.utils.MD5Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

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
            return R.ok(Response.OPERATION_200);
        }
        return R.fail(Response.OPERATION_FAIL);
    }

    @Override
    @Transactional
    public R login(PostAdmin postAdmin) {
        String saltPassword = MD5Util.hashPassword(postAdmin.getPassword());
        postAdmin.setPassword(saltPassword);
        PostAdmin admin = postAdminMapper.login(postAdmin);
        if (admin != null) {
            String flag = UUID.randomUUID().toString().replaceAll("-", "");
            admin.setLoginFlag(flag);
            int count = postAdminMapper.updateLoginFlag(admin);
            if (count == 1) {
                return R.ok(Response.LOGIN_200,flag);
            }
        }
        return R.fail(Response.LOGIN_FAIL);
    }

    @Override
    public R checkLogin(PostAdmin postAdmin) {
        PostAdmin admin = this.postAdminMapper.getLoginStatus(postAdmin);
        if (admin != null) {
            return R.ok(Response.QUERY_200);
        }
        return R.fail(Response.QUERY_FAIL);
    }


}
