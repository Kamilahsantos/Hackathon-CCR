package com.ccr.hackathon.backend.model;

import com.ccr.hackathon.backend.enums.GENDER;
import com.ccr.hackathon.backend.enums.SCHOLARITY;
import com.ccr.hackathon.backend.enums.TRACK;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user_info")
public class User {

    private Long id;

    private String name;

    private String documentNumber;

    private GENDER gender;

    private SCHOLARITY scholarity;

    private Long familyIncome;

    private TRACK track;

    private Long score;

    private String experience;

    private String address;

    private String phoneNumber;

    private Date birthDate;

    private LocalDateTime createdAt;

    private String projects;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", length = 255, nullable = true)
    @Size(max = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "documentNumber", length = 255, nullable = true)
    @Size(max = 255)
    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @Column(name = "gender", length = 255, nullable = true)
    @Size(max = 255)
    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    @Column(name = "scholarity", length = 255, nullable = true)
    @Size(max = 255)
    public SCHOLARITY getScholarity() {
        return scholarity;
    }

    public void setScholarity(SCHOLARITY scholarity) {
        this.scholarity = scholarity;
    }

    @Column(name = "familyIncome", length = 255, nullable = true)
    @Size(max = 255)
    public Long getFamilyIncome() {
        return familyIncome;
    }

    public void setFamilyIncome(Long familyIncome) {
        this.familyIncome = familyIncome;
    }

    @Column(name = "track", length = 255, nullable = true)
    @Size(max = 255)
    public TRACK getTrack() {
        return track;
    }

    public void setTrack(TRACK track) {
        this.track = track;
    }

    @Column(name = "score", length = 255, nullable = true)
    @Size(max = 255)
    public Long getScore() {
        return score;
    }

    @Column(name = "experience", length = 255, nullable = true)
    @Size(max = 255)
    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
    @Column(name = "address", length = 255, nullable = true)
    @Size(max = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "phoneNumber", length = 255, nullable = true)
    @Size(max = 255)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "birthDate", length = 255, nullable = true)
    @Size(max = 255)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "birthDate", length = 255, nullable = true)
    @CreatedDate
    @CreationTimestamp
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    @Column(name = "birthDate", length = 255, nullable = true)
    @Size(max = 255)
    public String getProjects() {
        return projects;
    }

    public void setProjects(String projects) {
        this.projects = projects;
    }


    public void setScore(Long score) {
        this.score = score;
    }

    public User(Long id, String name, String documentNumber, GENDER gender, SCHOLARITY scholarity, Long familyIncome, TRACK track, Long score, String experience, String address, String phoneNumber, Date birthDate, LocalDateTime createdAt, String projects) {
        this.id = id;
        this.name = name;
        this.documentNumber = documentNumber;
        this.gender = gender;
        this.scholarity = scholarity;
        this.familyIncome = familyIncome;
        this.track = track;
        this.score = score;
        this.experience = experience;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.createdAt = createdAt;
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", gender=" + gender +
                ", scholarity=" + scholarity +
                ", familyIncome=" + familyIncome +
                ", track=" + track +
                ", score=" + score +
                ", experience='" + experience + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthDate=" + birthDate +
                ", createdAt=" + createdAt +
                ", projects=" + projects +
                '}';
    }

    public User() {
    }

}
