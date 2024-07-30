package com.example.PetnityServer.data.dto.postDTO;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ListPostsRequestDTO {
    private int pageCount;
    private int pageSize ;
    private String keyword;
}
