package com.example.PetnityServer.data.dto.postDTO;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreatePostResponseDTO {
    PostDTO post;
}
