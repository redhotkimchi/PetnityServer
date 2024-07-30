package com.example.PetnityServer.data.dto.postDTO;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
@Getter
@Builder
public class ListPostsResponseDTO {
    private List<PostDTO> posts;
    private int totalPostCount;
}
