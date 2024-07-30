package com.example.PetnityServer.controller;

import com.example.PetnityServer.data.dto.postDTO.CreatePostRequestDTO;
import com.example.PetnityServer.data.dto.postDTO.CreatePostResponseDTO;
import com.example.PetnityServer.data.dto.postDTO.PostDTO;
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
    public ResponseEntity<PostDTO> createPost(@RequestBody CreatePostRequestDTO createPostRequestDTO){
        PostDTO response = postService.createPost(createPostRequestDTO);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> readPost(@PathVariable Long id) {
        Optional<PostDTO> post = postService.readPost(id);
        return post.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
