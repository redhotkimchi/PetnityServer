package com.example.PetnityServer.data.dao.impl;

import com.example.PetnityServer.data.dao.PostDao;
import com.example.PetnityServer.data.dto.postDTO.PostDTO;
import com.example.PetnityServer.data.entity.Post;
import com.example.PetnityServer.data.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostDaoImpl implements PostDao {
    PostRepository postRepository;
     public PostDaoImpl(PostRepository postRepository) {
        this.postRepository = postRepository;}
    @Override
    public void forSave(PostDTO postDTO, String password) {
        // save post
        Post post = Post.builder()
                .title(postDTO.getTitle())
                .nickname(postDTO.getNickname())
                .dogName(postDTO.getDogName())
                .dogAge(postDTO.getDogAge())
                .location(postDTO.getLocation())
                .message(postDTO.getMessage())
                .password(password)
                .build();
        postRepository.save(post);
    }

    @Override
    public PostDTO forFindById(long id) {
        Optional<Post> postEntity = postRepository.findById(id);
        PostDTO post = postEntity.map(entity -> PostDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .nickname(entity.getNickname())
                .dogName(entity.getDogName())
                .dogAge(entity.getDogAge())
                .location(entity.getLocation())
                .message(entity.getMessage())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build()).orElse(null);
         return post;
    }
}
