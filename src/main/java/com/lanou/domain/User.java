package com.lanou.domain;

import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * Created by dllo on 17/11/8.
 */
public class User {
    private int id;
    @NotBlank(message = "*用户名不能为空")
    private String name;
    @NotBlank(message = "*密码不能为空")
    private String password;
    private int level;
    private String des;
    private String tel;
    private String address;


    private List<Blog> blogList;

    public User() {
    }

    public User(String name, String password, int level, String des, String tel, String address) {
        this.name = name;
        this.password = password;
        this.level = level;
        this.des = des;
        this.tel = tel;
        this.address = address;
    }

    public User(String name, String password, int level, String des, String tel, String address, List<Blog> blogList) {

        this.name = name;
        this.password = password;
        this.level = level;
        this.des = des;
        this.tel = tel;
        this.address = address;
        this.blogList = blogList;
    }

    public User(int id, String name, String password, int level, String des, String tel, String address, List<Blog> blogList) {

        this.id = id;
        this.name = name;
        this.password = password;
        this.level = level;
        this.des = des;
        this.tel = tel;
        this.address = address;
        this.blogList = blogList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", level=" + level +
                ", des='" + des + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}
