package com.salvadiploma.salvadiploma.model;

public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String confirmPassword;
    private String level;
    private String image;
    private String description;
    private String title;
    private String link;
    private String objective;
    private Number indexToArray;

    //getters

    public Number getIndexToArray() {
        return indexToArray;
    }
    public String getObjective() {
        return objective;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getLevel() {
        return level;
    }
    
    public String getImage() {
        return image;
    }

    public String getLink( ) {
        return link;
    }

    public String getTitle( ) {
        return title;
    }


    //setters 

    public void setIndexToArray(Number indexToArray) {
        this.indexToArray = indexToArray;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public void setNme(String name) {
        this.name = name;
    }

    public void setLink (String link) {
        this.link = link;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
