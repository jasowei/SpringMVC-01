package com.lanou.service;

import com.lanou.domain.Blog;
import com.lanou.domain.BlogExt;
import com.lanou.domain.User;

import java.util.List;

/**
 * Created by dllo on 17/11/8.
 */
public interface UserService {
    /**
     * 根据名字查用户
     * @param
     * @return
     */
    User findByName(User user);

    List<Blog> findBlogById(Integer userId);

    Blog findBlog(Integer blogId);

    int addBlog(Blog blog);

    int addUser(User user);

    int deleteBlog(Blog blog);

    List<Blog> findBlogByCotnt(BlogExt blogExt);

    int updateBlog(Blog blog);
}
