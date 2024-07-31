package com.example.PetnityServer.data.dto.postDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class UpdatePostRequest {
    private PostDTO post;
}
