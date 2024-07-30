package com.example.PetnityServer.service;

import com.example.PetnityServer.data.dto.postDTO.CreatePostRequestDTO;
import com.example.PetnityServer.data.dto.postDTO.CreatePostResponseDTO;
import com.example.PetnityServer.data.dto.postDTO.PostDTO;

import java.util.Optional;

public interface PostService {
    PostDTO createPost(CreatePostRequestDTO createPostRequestDTO);
    Optional<PostDTO> readPost(long id);
}
