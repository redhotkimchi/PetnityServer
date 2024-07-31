package com.example.PetnityServer.data.dto.postDTO;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class
ReadPostResponse
{
    private PostDTO post;
    //getter
    public PostDTO getPost() {
        return post;
    }
}

