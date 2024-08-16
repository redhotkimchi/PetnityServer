package com.example.PetnityServer.controller;

import com.example.PetnityServer.data.dto.postDTO.*;
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
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        if (postService.deletePost(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<UpdatePostResponse> updatePost(@PathVariable Long id, @RequestBody UpdatePostRequest updatePostRequest) {
        Optional<UpdatePostResponse> updatePostResponse = postService.updatePost(id, updatePostRequest);
        if (updatePostResponse.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatePostResponse.get());
    }

    @GetMapping
    public ResponseEntity<ListPostsResponseDTO> listPosts(@RequestParam ListPostsRequestDTO listPostsRequestDTO) {
        return  ResponseEntity.ok(
                postService.listPosts(listPostsRequestDTO)
        );
    }

}
