package com.example.PetnityServer.service.impl;

import com.example.PetnityServer.data.dto.postDTO.*;
import com.example.PetnityServer.data.entity.Post;
import com.example.PetnityServer.data.repository.PostRepository;
import com.example.PetnityServer.service.PostService;
import com.example.PetnityServer.service.converter.PostConverter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@NoArgsConstructor
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private PostConverter postConverter;

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

    @Override
    public boolean deletePost(long id) {
        if(postRepository.existsById(id)){
            postRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    @Transactional
    public Optional<UpdatePostResponse> updatePost(long id, UpdatePostRequest updatePostRequest) {
        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isEmpty()) {
            return Optional.empty();
        } else {
            Post post = postOptional.get();
            post.setTitle(updatePostRequest.getPost().getTitle());
            post.setMessage(updatePostRequest.getPost().getMessage());
            post.setDogAge(updatePostRequest.getPost().getDogAge());
            post.setDogName(updatePostRequest.getPost().getDogName());
            post.setLocation(updatePostRequest.getPost().getLocation());
            post.setNickname(updatePostRequest.getPost().getNickname());

            Post savedPost = postRepository.save(post);


            return Optional.of(UpdatePostResponse.builder()
                    .post(postConverter.convertToDto(savedPost))
                    .build());
        }

    }

}
