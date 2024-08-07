package com.example.PetnityServer.data.dto.postDTO;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostDTO {
    long id;
    String title;
    String nickname;
    String dogName;
    Short dogAge;
    String location;
    String message;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
