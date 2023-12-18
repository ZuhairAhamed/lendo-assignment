package com.lendo.assignment.service;

import com.lendo.assignment.model.CommentModel;
import reactor.core.publisher.Flux;

public interface CommentService {
    Flux<CommentModel> getAllComments();
}
