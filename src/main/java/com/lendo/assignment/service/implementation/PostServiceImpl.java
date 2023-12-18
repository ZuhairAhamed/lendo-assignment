package com.lendo.assignment.service.implementation;

import com.lendo.assignment.model.PostModel;
import com.lendo.assignment.service.PostService;
import com.lendo.assignment.util.WebClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class PostServiceImpl implements PostService {

    @Value("${url.post}")
    private String url;

    @Autowired
    private WebClientUtil webClientUtil;

    @Override
    public Flux<PostModel> getAllPosts() {

        return webClientUtil.getAll(url, PostModel.class);

    }
}
