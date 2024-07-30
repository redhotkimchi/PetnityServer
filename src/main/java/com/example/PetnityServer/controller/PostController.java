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
@RequestMapping("api/post")

public class PostController {
    private PostService postService;
    @Autowired
    public PostController(PostService postService){this.postService = postService;}

    @PostMapping(value = "/create")
    public ResponseEntity<CreatePostResponseDTO> createPost(@RequestBody CreatePostRequestDTO createPostRequestDTO){
        CreatePostResponseDTO response = postService.createPost(createPostRequestDTO);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long id) {
        Optional<PostDTO> post = postService.readPost(id);
        return post.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
