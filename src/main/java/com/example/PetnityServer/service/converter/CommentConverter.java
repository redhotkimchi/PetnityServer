package com.example.PetnityServer.service.converter;

import com.example.PetnityServer.data.dto.commentDTO.CommentDTO;

import com.example.PetnityServer.data.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {
    //DTO to Entity
    public static Comment convertToEntity(CommentDTO commentDTO) {
        return Comment.builder()
                .id(commentDTO.getId())
                .message(commentDTO.getMessage())
                .password("")
                .salt("")
                .build();
    }
    //Entity to DTO
    public static CommentDTO convertToDto(Comment comment) {
        return CommentDTO.builder()
                .id(comment.getId())
                .postId(comment.getPost().getId())
                .message(comment.getMessage())
                .createdDate(comment.getCreatedAt())
                .updatedDate(comment.getUpdatedAt())
                .build();
    }
}
