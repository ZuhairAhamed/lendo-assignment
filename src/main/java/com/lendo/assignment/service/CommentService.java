package com.lendo.assignment.service;

import com.lendo.assignment.model.CommentModel;

import java.util.List;

public interface CommentService {
    List<CommentModel> getAllComments();

    List<CommentModel> getFilteredComment(Integer postId);
}
