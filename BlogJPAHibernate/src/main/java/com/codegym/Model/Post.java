package com.codegym.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Post")
public class Post {
    @Id
    private int Id;

    private String title;
    private String author;
    private String content;
    private String createdDate;
    private String updatedDate;

    public Post(){
    }

    public Post(int id, String title, String author, String content) {
        Id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Post(int id, String title, String author, String content, String createdDate, String updatedDate) {
        Id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
}
