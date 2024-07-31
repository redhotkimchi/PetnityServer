package com.example.PetnityServer.service;

import com.example.PetnityServer.data.dto.postDTO.CreatePostRequestDTO;
import com.example.PetnityServer.data.dto.postDTO.CreatePostResponseDTO;
import com.example.PetnityServer.data.dto.postDTO.PostDTO;
import com.example.PetnityServer.data.dto.postDTO.ReadPostResponse;

import java.util.Optional;

public interface PostService {
    CreatePostResponseDTO createPost(CreatePostRequestDTO createPostRequestDTO);
    Optional<ReadPostResponse> readPost(long id);
}
