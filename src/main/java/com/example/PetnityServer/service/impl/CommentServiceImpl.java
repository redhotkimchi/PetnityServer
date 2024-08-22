package com.example.PetnityServer.service.impl;

import com.example.PetnityServer.data.dto.commentDTO.*;
import com.example.PetnityServer.data.entity.Comment;
import com.example.PetnityServer.data.entity.Post;
import com.example.PetnityServer.data.repository.CommentRepository;
import com.example.PetnityServer.data.repository.PostRepository;
import com.example.PetnityServer.service.CommentService;
import com.example.PetnityServer.service.converter.CommentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final CommentConverter commentConverter;
    private final PostRepository postRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, CommentConverter commentConverter, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.commentConverter = commentConverter;
        this.postRepository = postRepository;
    }

    @Override
    public CreateCommentResponse createComment(CreateCommentRequest createCommentRequest, Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        String password = createCommentRequest.getPassword();
        CommentDTO commentDTO = createCommentRequest.getComment();
        commentDTO.setId(0L);
        Comment comment = commentConverter.convertToEntity(commentDTO);
        comment.setPost(post);
        comment.setPassword(password);
        comment.setSalt("");
        Comment savedComment = commentRepository.save(comment);
        return CreateCommentResponse.builder()
                .comment(commentConverter.convertToDto(savedComment))
                .build();

    }

    @Override
    @Transactional
    public Optional<UpdateCommentResponse> updateComment(UpdateCommentRequest updateCommentRequest, Long postId, Long commentId) {
        if(!postRepository.existsById(postId)){
            return Optional.empty();
        }
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new RuntimeException("Comment not found"));
        if (comment.getPost().getId() != postId) {
            return Optional.empty();
        }
        CommentDTO commentDTO = updateCommentRequest.getComment();
        comment.setMessage(commentDTO.getMessage());
        Comment updatedComment = commentRepository.save(comment);
        return Optional.of(UpdateCommentResponse.builder()
                .comment(commentConverter.convertToDto(updatedComment))
                .build());
    }

    @Override
    public boolean deleteComment(Long commentId) {
        if (commentRepository.existsById(commentId)) {
            commentRepository.deleteById(commentId);
            return true;
        }
        return false;
    }

    @Override
    public Optional<ListCommentsResponse> listComments(Long postId) {
        //find comments by post id
        Optional<List<Comment>> comments = commentRepository.findByPostId(postId);
        if (comments.isEmpty()) {
            return Optional.empty();
        }
        List<CommentDTO> commentDTOS = new ArrayList<>();
        for (Comment comment : comments.get()) {
            commentDTOS.add(commentConverter.convertToDto(comment));
        }
        return Optional.of(ListCommentsResponse.builder()
                .comments(commentDTOS)
                .build());
    }
}
