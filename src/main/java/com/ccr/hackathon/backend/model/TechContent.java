package com.ccr.hackathon.backend.model;


import javax.persistence.*;

@Entity
@Table(name = "tech_content")
public class TechContent {


    private Long id;
    private String title;
    private String description;
    private String url;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TechContent() {
    }

    public TechContent(Long id, String title, String description, String url) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
    }


    @Override
    public String toString() {
        return "Activity [id=" + id + ", title=" + title + ", description=" + description + ", url=" + url + "]";
    }


}
