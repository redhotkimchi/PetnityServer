package com.example.PetnityServer.service.converter;

import com.example.PetnityServer.data.dto.postDTO.PostDTO;
import com.example.PetnityServer.data.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {
    public static PostDTO convertToDto(Post post) {
        return PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .message(post.getMessage())
                .dogAge(post.getDogAge())
                .dogName(post.getDogName())
                .location(post.getLocation())
                .nickname(post.getNickname())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }

    public static Post convertToEntity(PostDTO postDTO) {
        return Post.builder()
                .id(postDTO.getId())
                .title(postDTO.getTitle())
                .message(postDTO.getMessage())
                .dogAge(postDTO.getDogAge())
                .dogName(postDTO.getDogName())
                .location(postDTO.getLocation())
                .nickname(postDTO.getNickname())
                .password("")
                .salt("")
                .build();
    }

}
