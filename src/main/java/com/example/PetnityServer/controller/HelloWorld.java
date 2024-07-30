package com.example.PetnityServer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    private PostService postService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @POST("/posts/{"id"}")
    public CreatePostReponseDTO postResponse(CreatePostRequestDTO request) {

        startTransaction();
        PostDTO post = request.getPost();
        String password = request.getPassword();

        if (post == null) {
            return InvalidError(400, "no post");
        }
        if (password == null) {
            return InvalidError(401, "no password");
        }
        try {
            // PostService
            // 1. password 암호화
            // 2. 필드 검사 ) 예를 들어 dogAge >= 100 이면 미쳤니?

            // 3. DB에 데이터 쿼리
            // return
            PostDTO created = this.postService.create(post, password);
            return new CreatePostReponseDTO(created);
        } catch (Error e) {
            return InvalidError(400, "error e occrered");
        }
        commintTransaction();
    }
}

interface PostService {
    PostDTO create(PostDTO input, String password);
}


class  PostServiceImpl implements PostService {

    private PostConverter converter;

    PostDTO create(PostDTO input, String password) {

        String salt = Random.generateSalt();
        String encryped = Agron2.encyrpt(password + salt);
        // input에 대한 로직들... 기타등등
        // 비즈니스 로직
        // 여성시대 -> 남자는 밴

        // DAO entity
        // DTO <-> Entity 컨버전

        Post post = input.toEntity();
        post.password = encryped;
        Post createdPost = this.respository.create(post);
        PostDTO createdPostDTO = new PostDTO(createdPost);
        return createdPostDTO;
    }

    private convertForward(PostDTO postDTO): Post;

    private convertBackward(Post post): PostDTO;
}

class Converter {

    forward()
        backward();
}

// 서비스 -> 비즈니스 로직


@StartTranscation
this.acocuntService.withDrawMoney(); -> 여긴 잘 됨
this.itemService.addItem(); -> 터짐
@CommitTransaction


