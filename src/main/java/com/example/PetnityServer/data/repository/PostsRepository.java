package com.example.PetnityServer.data.repository;

import com.example.PetnityServer.data.entity.PostsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<PostsEntity, Long> {
}
