package com.example.PetnityServer.service.impl;

import com.example.PetnityServer.data.dto.postDTO.CreatePostRequestDTO;
import com.example.PetnityServer.data.dto.postDTO.CreatePostResponseDTO;
import com.example.PetnityServer.data.dto.postDTO.PostDTO;
import com.example.PetnityServer.data.dto.postDTO.ReadPostResponse;
import com.example.PetnityServer.data.entity.Post;
import com.example.PetnityServer.data.repository.PostRepository;
import com.example.PetnityServer.service.PostService;
import com.example.PetnityServer.service.converter.PostConverter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@NoArgsConstructor
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private PostConverter postConverter;
    @Autowired
    public PostServiceImpl(PostRepository postRepository, PostConverter postConverter){
        this.postRepository = postRepository;
        this.postConverter = postConverter;
    }

    @Override
    public CreatePostResponseDTO createPost(CreatePostRequestDTO createPostRequestDTO) {
        String password = createPostRequestDTO.getPassword();
        Post post = postConverter.convertToEntity(createPostRequestDTO.getPost());
        post.builder()
                .password(password)
                .build();
        Post savedPost = postRepository.save(post);
        CreatePostResponseDTO createPostResponseDTO = CreatePostResponseDTO.builder()
                .post(postConverter.convertToDto(savedPost))
                .build();
        return createPostResponseDTO;

    }

    @Override
    public Optional<ReadPostResponse> readPost(long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {
            return Optional.empty();
        }
        else {
            return Optional.of(ReadPostResponse.builder()
                    .post(postConverter.convertToDto(post.get()))
                    .build());
        }

    }

}
