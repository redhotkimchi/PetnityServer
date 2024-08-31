package com.example.PetnityServer.service;

import com.example.PetnityServer.data.dto.commentDTO.*;

import java.util.Optional;

public interface CommentService {
    //create comment
    public CreateCommentResponse createComment(CreateCommentRequest comment, Long PostId);
    //update comment
    public Optional<UpdateCommentResponse> updateComment(UpdateCommentRequest comment, Long commentId, Long postId);
    //delete comment
    public boolean deleteComment(Long commentId);
    //list comments
    public Optional<ListCommentsResponse> listComments(Long postId);
}
