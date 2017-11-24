package com.lanou.mapper;

import com.lanou.domain.Blog;
import com.lanou.domain.BlogExt;
import com.lanou.domain.User;

import java.util.List;

/**
 * Created by dllo on 17/11/8.
 */
public interface UserMapper {

    /**
     * 根据用户名获取对象
     * @param
     * @return
     */
    User findByName(User user);

    /**
     * 根据用户id查其博客
     * @param userId
     * @return
     */
    List<Blog> findBlogById(Integer userId);
    /**
     * 根据博客id查询详情
     */
    Blog findBlog(Integer blogId);
    /**
     * 新建博客
     */
    int addBlog(Blog blog);

    int addUser(User user);

    int deleteBlog(Blog blog);

    List<Blog> findBlogByCotnt(BlogExt blogExt);

    int updateBlog(Blog blog);
}
