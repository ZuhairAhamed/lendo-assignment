package com.lendo.assignment.service.implementation;

import com.lendo.assignment.model.CommentModel;
import com.lendo.assignment.service.CommentService;
import com.lendo.assignment.util.WebClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Objects;

@Service
public class CommentServiceImpl implements CommentService {

    @Value("${url.comment}")
    private String url;

    @Autowired
    private WebClientUtil webClientUtil;

    @Override
    public List<CommentModel> getAllComments() {

        Flux<CommentModel> commentModelFlux = webClientUtil.getAll(url, CommentModel.class);
        return commentModelFlux.collectList().block();

    }

    @Override
    public List<CommentModel> getFilteredComment(Integer postId) {
        Flux<CommentModel> commentModelFlux = webClientUtil.getAll(url, CommentModel.class);
        return Objects.requireNonNull(commentModelFlux.collectList().block()).stream().filter(commentModel -> commentModel.getPost_id().equals(postId)).toList();
    }

}
