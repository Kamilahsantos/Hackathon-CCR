package com.ccr.hackathon.backend.model;


import javax.persistence.*;
import javax.validation.constraints.Size;

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

    @Column(name = "title", length = 255, nullable = true)
    @Size(max = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description", length = 255, nullable = true)
    @Size(max = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "url", length = 255, nullable = true)
    @Size(max = 255)
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
        return "TechContent [id=" + id + ", title=" + title + ", description=" + description + ", url=" + url + "]";
    }


}
