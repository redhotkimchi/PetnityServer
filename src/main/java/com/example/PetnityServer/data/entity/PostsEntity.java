package com.example.PetnityServer.data.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "postTable")
public class PostsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 512)
    private String password;

    @Column(nullable = false, length = 6)
    private String salt;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private Integer dogAge;

    @Column(nullable = false, length = 25)
    private String dogName;

    @Column(nullable = false, length = 50)
    private String location;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

    // Constructors, Getters, and Setters

    public PostsEntity() {}

    public PostsEntity(String password, String salt, String title, String message, Integer dogAge, String dogName, String location, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.password = password;
        this.salt = salt;
        this.title = title;
        this.message = message;
        this.dogAge = dogAge;
        this.dogName = dogName;
        this.location = location;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getDogAge() {
        return dogAge;
    }

    public void setDogAge(Integer dogAge) {
        this.dogAge = dogAge;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}