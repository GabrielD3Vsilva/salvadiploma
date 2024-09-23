package com.salvadiploma.salvadiploma.model;

import java.util.Objects;

public class Post {
    private String name;
    private String image;
    private String title;
    private String objective;
    private String description;
    private String link;


    // Construtor
    public Post( String title, String description, String objective, String link, String name, String image ) {
        this.title = title;
        this.objective = objective;
        this.description = description;
        this.link = link;
        this.name = name;
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(description, post.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }


    // Métodos de acesso (getters e setters)
    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getImage ( ) {
        return image;
    }

    public void setImage ( String image ) {
        this.image = image;
    }

    public String getLink ( ) {
        return link;
    }

    public void setLink (String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
