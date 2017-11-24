package com.lanou.service.impl;

import com.lanou.domain.Blog;
import com.lanou.domain.BlogExt;
import com.lanou.domain.User;
import com.lanou.mapper.UserMapper;
import com.lanou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dllo on 17/11/8.
 */

@Service("userService")
public class UserServiceImpl implements UserService {


    /**
     * 持有的dao层对象
     */
    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;


    public User findByName(User user) {
        return userMapper.findByName(user);
    }

    public List<Blog> findBlogById(Integer userId) {
        return userMapper.findBlogById(userId);
    }

    public Blog findBlog(Integer blogId) {
        return userMapper.findBlog(blogId);
    }

    public int addBlog(Blog blog) {
        return userMapper.addBlog(blog);
    }

    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    public int deleteBlog(Blog blog) {
        return userMapper.deleteBlog(blog);
    }

    public List<Blog> findBlogByCotnt(BlogExt blogExt) {
        return userMapper.findBlogByCotnt(blogExt);
    }

    public int updateBlog(Blog blog) {
        return userMapper.updateBlog(blog);
    }


}
