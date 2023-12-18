package com.lendo.assignment.service;

import com.lendo.assignment.model.PostModel;
import reactor.core.publisher.Flux;

public interface PostService {

    public Flux<PostModel> getAllPosts();
}
