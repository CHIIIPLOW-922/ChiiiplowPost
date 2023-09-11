package com.chiiiplow.post.controller;

import com.chiiiplow.post.components.R;
import com.chiiiplow.post.entity.enums.Response;
import com.chiiiplow.post.entity.pojo.PostAdmin;
import com.chiiiplow.post.service.PostAdminService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author CHIIIPLOW
 * @date 2023/09/10
 */
@RestController
@RequestMapping("/admin")
public class PostAdminController {
    @Resource
    private PostAdminService postAdminService;

    /**
     *	添加后台管理员接口
     */
    @RequestMapping(path = "/addPostAdmin", method = RequestMethod.POST)
    public R  addPostAdmin(@RequestBody PostAdmin postAdmin){
        try{
        return this.postAdminService.addPostAdmin(postAdmin);
        }catch (Exception e){
            return R.fail(Response.CODE_500);
        }
    }

    /**
     *	登录后台管理员接口
     */
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public R  loginPostAdmin(@RequestBody PostAdmin postAdmin){
        try{
            return this.postAdminService.login(postAdmin);
        }catch (Exception e){
            return R.fail(Response.CODE_500);
        }
    }

}
