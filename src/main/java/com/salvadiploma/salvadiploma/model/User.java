package com.salvadiploma.salvadiploma.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String level;
    private String image;
    private List<Object> posts; // Alteração do tipo para List<Object>
    // Construtor sem parâmetros
    public User() {
        this.posts = new ArrayList<>();
    }

    // Construtor com parâmetros
    public User(String name, String email, String password, String level, String image) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.level = level;
        this.image = image;
        this.posts = new ArrayList<>();
    }

    // Getters e setters
    public List<Object> getPosts() {
        return posts;
    }


    public void setPosts(List<Object> posts) {
        this.posts = posts;
    }

    public void addPost(Object post) {
        this.posts.add(post); // Método para adicionar um objeto à lista
    }


    public String getName() {
        return name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}