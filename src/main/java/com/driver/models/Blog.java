package com.driver.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity

public class Blog {

    public Blog() {
        imageList=new ArrayList<>();
    }

    public Blog(String title, String content) {
        this.content=content;
        this.title=title;
        imageList=new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     int id;
     String title;

     String content;

    Date pub;

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    List<Image> imageList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public Date getPub() {
        return pub;
    }

    public void setPub(Date pub) {
        this.pub = pub;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> x) {
        this.imageList=x;
    }

    @ManyToOne
    @JoinColumn
    User user;


}