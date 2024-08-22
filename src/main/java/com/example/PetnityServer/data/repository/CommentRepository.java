package com.example.PetnityServer.data.repository;

import com.example.PetnityServer.data.entity.Comment;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    //find comments by post id
    Optional<List<Comment>> findByPostId(Long postId);
}
