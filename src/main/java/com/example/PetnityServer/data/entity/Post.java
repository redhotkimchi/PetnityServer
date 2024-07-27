package com.example.PetnityServer.data.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
//message, title columns are indexed
@Table(name = "post",
        indexes = {@Index(name = "idx_title",  columnList="title"),
                @Index(name = "idx_message", columnList="message"),
                }
)
//class name has been changed to Post
public class Post {

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
    //dogAge column is nullable
    @Column(nullable = true)
    private Short dogAge;

    @Column(nullable = false, length = 25)
    private String dogName;
    //location column is nullable
    @Column(nullable = true, length = 50)
    private String location;
    //@CreationTimestamp annotation is used to update the created_at column
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    //@UpdateTimestamp annotation is used to update the update_at column
    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // Constructors, Getters, and Setters

    public Post() {}

    public Post(String password, String salt, String title, String message, Short dogAge, String dogName, String location, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.password = password;
        this.salt = salt;
        this.title = title;
        this.message = message;
        this.dogAge = dogAge;
        this.dogName = dogName;
        this.location = location;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public Short getDogAge() {
        return dogAge;
    }

    public void setDogAge(Short dogAge) {
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
        return updatedAt;
    }

    public void setUpdateAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}