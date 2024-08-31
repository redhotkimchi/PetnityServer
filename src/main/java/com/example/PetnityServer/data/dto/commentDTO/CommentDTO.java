package com.example.PetnityServer.data.dto.commentDTO;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    // The id of the comment
    private Long id;
    // The id of the post that the comment is on
    private Long postId;
    // message of the comment
    private String message;
    // The created date of the comment
    private LocalDateTime createdDate;
    // the updated date of the comment
    private LocalDateTime updatedDate;

}
