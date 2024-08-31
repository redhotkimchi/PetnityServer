package com.example.PetnityServer.data.dto.commentDTO;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateCommentResponse {
    private CommentDTO comment;

}
