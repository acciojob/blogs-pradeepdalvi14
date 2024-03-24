package com.driver.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

     String userName;
     String password;

     @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Blog> arr;

    public User() {
        arr = new ArrayList<>();
    }

    public User(String userName, String password){
         this.userName = userName;
         this.password = password;
         arr = new ArrayList<>();
     }
    public User(Integer userId) {
        arr=new ArrayList<>();
        id=userId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName(){
         return userName;
     }

    public void setUsername(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }

    public List<Blog> getBlogList() {
        return arr;
    }

    public void setBlogList(List<Blog> x) {
        this.arr=x;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}