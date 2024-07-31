package com.example.PetnityServer.data.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
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

    @Column(nullable = false, length = 256)
    private String nickname;

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
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    //@UpdateTimestamp annotation is used to update the update_at column
    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // Constructors, Getters, and Setters

    public Post() {
    }
}