package com.arindam.microservice.entity;

import java.util.Date;

public class Post {

    private int id;
    private Date post_date;
    private String post_content;
    private String post_status;
    private int post_like_counter;
    private int post_comment_counter;

    public Post() {
    }

    public Post(Date post_date, String post_content, String post_status, int post_like_counter, int post_comment_counter) {
        this.post_date = post_date;
        this.post_content = post_content;
        this.post_status = post_status;
        this.post_like_counter = post_like_counter;
        this.post_comment_counter = post_comment_counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPost_date() {
        return post_date;
    }

    public void setPost_date(Date post_date) {
        this.post_date = post_date;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public String getPost_status() {
        return post_status;
    }

    public void setPost_status(String post_status) {
        this.post_status = post_status;
    }

    public int getPost_like_counter() {
        return post_like_counter;
    }

    public void setPost_like_counter(int post_like_counter) {
        this.post_like_counter = post_like_counter;
    }

    public int getPost_comment_counter() {
        return post_comment_counter;
    }

    public void setPost_comment_counter(int post_comment_counter) {
        this.post_comment_counter = post_comment_counter;
    }
}
