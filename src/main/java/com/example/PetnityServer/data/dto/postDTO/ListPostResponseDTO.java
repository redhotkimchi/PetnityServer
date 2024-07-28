package com.example.PetnityServer.data.dto.postDTO;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
@Getter
@Builder
public class ListPostResponseDTO {
    private List<PostDTO> postDTOList;
    private int totalPostCount;
}
