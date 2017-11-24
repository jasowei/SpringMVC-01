package com.lanou.domain;

/**
 * Created by dllo on 17/11/9.
 */
public class BlogExt {
    private String content;
    private int uid;

    public BlogExt() {
    }

    public BlogExt(Integer userId) {
    }

    public BlogExt(String content, int uid) {

        this.content = content;
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "BlogExt{" +
                "content='" + content + '\'' +
                ", uid=" + uid +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
