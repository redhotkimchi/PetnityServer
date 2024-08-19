package com.example.PetnityServer.data.dto.postDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
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
