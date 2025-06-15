package com.library.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long membId;

    private LocalDate membDate;
    private String membType;
    private String name;
    private String address;
    private LocalDate expiryDate;

    public Member() {}

    public Member(LocalDate membDate, String membType, String name, String address, LocalDate expiryDate) {
        this.membDate = membDate;
        this.membType = membType;
        this.name = name;
        this.address = address;
        this.expiryDate = expiryDate;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public LocalDate getMembDate() {
        return membDate;
    }

    public void setMembDate(LocalDate membDate) {
        this.membDate = membDate;
    }

    public String getMembType() {
        return membType;
    }

    public void setMembType(String membType) {
        this.membType = membType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}
