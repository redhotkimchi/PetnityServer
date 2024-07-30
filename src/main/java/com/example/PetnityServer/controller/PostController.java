package com.example.PetnityServer.controller;

import com.example.PetnityServer.data.dto.postDTO.CreatePostRequestDTO;
import com.example.PetnityServer.data.dto.postDTO.CreatePostResponseDTO;
import com.example.PetnityServer.data.dto.postDTO.PostDTO;
import com.example.PetnityServer.data.dto.postDTO.ReadPostResponse;
import com.example.PetnityServer.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/posts")

public class PostController {
    private PostService postService;
    @Autowired

    public PostController(PostService postService){this.postService = postService;}

    @PostMapping
    public ResponseEntity<CreatePostResponseDTO> createPost(@RequestBody CreatePostRequestDTO createPostRequestDTO){
        CreatePostResponseDTO createPostResponseDTO = postService.createPost(createPostRequestDTO);
        return ResponseEntity.ok(createPostResponseDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ReadPostResponse> readPost(@PathVariable Long id) {
        Optional<ReadPostResponse> readPostResponse = postService.readPost(id);
        if (readPostResponse.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(readPostResponse.get());
    }


}
