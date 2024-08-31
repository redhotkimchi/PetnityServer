package com.example.PetnityServer.data.dto.commentDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class ListCommentsResponse {
    private List<CommentDTO> comments;
}
