package com.lendo.assignment.service.implementation;

import com.lendo.assignment.model.PostModel;
import com.lendo.assignment.service.PostService;
import com.lendo.assignment.util.WebClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Objects;

@Service
public class PostServiceImpl implements PostService {

    @Value("${url.post}")
    private String url;

    @Autowired
    private WebClientUtil webClientUtil;

    @Override
    public List<PostModel> getAllPosts() {

        Flux<PostModel> postModelFlux = webClientUtil.getAll(url, PostModel.class);
        return postModelFlux.collectList().block();

    }

    @Override
    public List<PostModel> getFilteredPost(Integer userId) {
        Flux<PostModel> postModelFlux = webClientUtil.getAll(url, PostModel.class);
        return Objects.requireNonNull(postModelFlux.collectList().block()).stream().filter(postModel -> postModel.getUser_id().equals(userId)).toList();
    }
}
