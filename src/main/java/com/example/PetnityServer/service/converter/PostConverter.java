package com.example.PetnityServer.service.converter;

import com.example.PetnityServer.data.dto.postDTO.CreatePostRequestDTO;
import com.example.PetnityServer.data.dto.postDTO.CreatePostResponseDTO;
import com.example.PetnityServer.data.dto.postDTO.PostDTO;
import com.example.PetnityServer.data.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {
public static PostDTO toPostDTO(Post post) {
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

    public static Post toPost(CreatePostRequestDTO createPostRequestDTO) {
        return Post.builder()
                .title(createPostRequestDTO.getPost().getTitle())
                .message(createPostRequestDTO.getPost().getMessage())
                .dogName(createPostRequestDTO.getPost().getDogName())
                .dogAge(createPostRequestDTO.getPost().getDogAge())
                .nickname(createPostRequestDTO.getPost().getNickname())
                .location(createPostRequestDTO.getPost().getLocation())
                .password(createPostRequestDTO.getPassword())
                .build();
    }

    public static CreatePostResponseDTO toCreatePostResponseDTO(Post post) {
        return CreatePostResponseDTO.builder()
                .post(toPostDTO(post))
                .build();
    }
}
