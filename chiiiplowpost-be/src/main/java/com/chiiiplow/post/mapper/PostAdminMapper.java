package com.chiiiplow.post.mapper;

import com.chiiiplow.post.entity.pojo.PostAdmin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author CHIIIPLOW
 * @date 2023/09/11
 */
@Mapper
public interface PostAdminMapper {

    /**
     * 添加管理员
     */
    int addAdmin(PostAdmin postAdmin);

    PostAdmin login(PostAdmin postAdmin);
}
