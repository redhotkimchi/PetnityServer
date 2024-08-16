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

import java.util.ArrayList;
import java.util.List;
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
        PostDTO dto = createPostRequestDTO.getPost();
        // clean up the ID
        dto.setId(0);
        Post post = postConverter.convertToEntity(dto);
        post.setPassword(password);
        post.setSalt("");

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
        PostDTO dto = updatePostRequest.getPost();
        // updated_at
        dto.setId(id);

        Post post = postConverter.convertToEntity(dto);
        // TODO : implement password / salt logic
        post.setPassword("");
        post.setSalt("");
        postRepository.save(post);
        // updated_at

        Post updated = postRepository.findById(post.getId()).get();

        // post -> dto
        PostDTO updatedDTO = postConverter.convertToDto(updated);
        // return data
        return Optional.of(UpdatePostResponse.builder().post(updatedDTO).build());
    }

    @Override
    public ListPostsResponseDTO listPosts(ListPostsRequestDTO listPostsRequestDTO) {
        List<Post> posts = postRepository.findAll();
        List<PostDTO> postDTOs = new ArrayList<>();
        for (Post post : posts) {
            PostDTO postDTO = postConverter.convertToDto(post);
            postDTOs.add(postDTO);
        }
        return ListPostsResponseDTO.builder().posts(postDTOs).build();
    }

}
