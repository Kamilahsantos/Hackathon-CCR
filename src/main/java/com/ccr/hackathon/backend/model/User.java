package com.ccr.hackathon.backend.model;

import com.ccr.hackathon.backend.enums.GENDER;
import com.ccr.hackathon.backend.enums.SCHOLARITY;
import com.ccr.hackathon.backend.enums.TRACK;

import javax.persistence.*;
import javax.validation.constraints.Size;

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

    public User(Long id, String name, String documentNumber, GENDER gender, SCHOLARITY scholarity, Long familyIncome, TRACK track) {

        this.id = id;
        this.name = name;
        this.documentNumber = documentNumber;
        this.gender = gender;
        this.scholarity = scholarity;
        this.familyIncome = familyIncome;
        this.track = track;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", documentNumber=" + documentNumber + ", gender=" + gender + ", scholarity =" + scholarity + ", familyIncome=" + familyIncome + ", track=" + track + "]";
    }
}
