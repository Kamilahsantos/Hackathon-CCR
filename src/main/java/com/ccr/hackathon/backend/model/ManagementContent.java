package com.ccr.hackathon.backend.model;

import com.ccr.hackathon.backend.enums.LEVEL;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "adm_content")
public class ManagementContent {
    private Long id;
    private String title;
    private String description;
    private String url;
    private LEVEL level;


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


    @Column(name = "level", length = 255, nullable = true)
    @Size(max = 255)
    public LEVEL getLevel() {
        return level;
    }

    public void setLevel(LEVEL level) {
        this.level = level;
    }

    public ManagementContent() {
    }

    public ManagementContent(Long id, String title, String description, String url, LEVEL level) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.level = level;

    }


    @Override
    public String toString() {
        return "ManagementContent [id=" + id + ", title=" + title + ", description=" + description + ", url=" + url +", level="+ level +"]";
    }

}
