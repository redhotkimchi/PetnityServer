package com.example.PetnityServer.controller;

import com.example.PetnityServer.data.dto.commentDTO.*;
import com.example.PetnityServer.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/comments")
public class CommentController {
    //create comment
    //update comment
    //delete comment
    //list comments
    private final CommentService commentService;
    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/{postId}")
    public ResponseEntity<CreateCommentResponse> createComment(@RequestBody CreateCommentRequest createCommentRequest, @PathVariable Long postId) {
        CreateCommentResponse createCommentResponse = commentService.createComment(createCommentRequest, postId);
        return ResponseEntity.ok(createCommentResponse);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<ListCommentsResponse> listComments(@PathVariable Long postId) {
        Optional<ListCommentsResponse> listCommentsResponse = commentService.listComments(postId);
        if (listCommentsResponse.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listCommentsResponse.get());
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        if (commentService.deleteComment(commentId)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{postId}/{commentId}")
    public ResponseEntity<UpdateCommentResponse> updateComment(@RequestBody UpdateCommentRequest updateCommentRequest, @PathVariable Long postId, @PathVariable Long commentId) {
        Optional<UpdateCommentResponse> updateCommentResponse = commentService.updateComment(updateCommentRequest, postId, commentId);
        if (updateCommentResponse.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateCommentResponse.get());
    }

}
