package com.example.PetnityServer.data.dao;

import com.example.PetnityServer.data.dto.postDTO.PostDTO;

public interface PostDao {
    void forSave(PostDTO postDTO, String password);
    PostDTO forFindById(long id);
}
