package com.example.PetnityServer.data.dto.postDTO;

import lombok.*;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePostRequest {
    private PostDTO post;
}
