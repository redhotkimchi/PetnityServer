package com.example.PetnityServer.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 512)
    private String password;
    @Column(nullable = false, length = 6)
    private String salt;
    @Column(nullable = false, length = 256)
    private String message;
    @CreationTimestamp
    @Column( nullable = false, updatable = false)
    private LocalDateTime createdAt;
    //@UpdateTimestamp annotation is used to update the update_at column
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    //set the post
    public void setPost(Post post) {
        this.post = post;
        post.getComments().add(this);
    }

}
