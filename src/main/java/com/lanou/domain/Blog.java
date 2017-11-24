package com.lanou.domain;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by dllo on 17/11/8.
 */
public class Blog {
    private int id;
    private String title;//标题
    private String des;//描述
    private String content;//详情
    private int userId;

    private User user;

    public Blog() {
    }

    public Blog(String title, String des, String content, int userId) {
        this.title = title;
        this.des = des;
        this.content = content;
        this.userId = userId;
    }

    public Blog(String title, String des, String content, int userId, User user) {

        this.title = title;
        this.des = des;
        this.content = content;
        this.userId = userId;
        this.user = user;
    }

    public Blog(int id, String title, String des, String content, int userId, User user) {

        this.id = id;
        this.title = title;
        this.des = des;
        this.content = content;
        this.userId = userId;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", des='" + des + '\'' +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
