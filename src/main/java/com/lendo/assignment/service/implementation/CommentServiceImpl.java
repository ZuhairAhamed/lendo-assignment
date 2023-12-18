package com.lendo.assignment.service.implementation;

import com.lendo.assignment.model.CommentModel;
import com.lendo.assignment.service.CommentService;
import com.lendo.assignment.util.WebClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CommentServiceImpl implements CommentService {

    @Value("${url.comment}")
    private String url;

    @Autowired
    private WebClientUtil webClientUtil;

    @Override
    public Flux<CommentModel> getAllComments() {

        return webClientUtil.getAll(url, CommentModel.class);

    }

}
