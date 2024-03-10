package com.example.star_wars_project.model.view;

import com.example.star_wars_project.model.entity.Picture;

public class AllGamesViewModel {
    private Long id;
    private String title;
    private String description;
    private Picture picture;

    public AllGamesViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}