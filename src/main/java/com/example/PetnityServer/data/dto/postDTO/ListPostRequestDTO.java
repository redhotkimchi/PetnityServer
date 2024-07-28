package com.example.PetnityServer.data.dto.postDTO;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ListPostRequestDTO {
    private int pageCount;
    private int pageSize ;
    private String Keyword;
}
