package com.example.PetnityServer.service;

import com.example.PetnityServer.data.dto.postDTO.*;

import java.util.Optional;

public interface PostService {
    CreatePostResponseDTO createPost(CreatePostRequestDTO createPostRequestDTO);
    Optional<ReadPostResponse> readPost(long id);
    boolean deletePost(long id);
    Optional<UpdatePostResponse> updatePost(long id, UpdatePostRequest updatePostRequest);
    ListPostsResponseDTO listPosts();
}
