package com.lendo.assignment.service;

import com.lendo.assignment.model.PostModel;

import java.util.List;

public interface PostService {

    public List<PostModel> getAllPosts();

    public List<PostModel> getFilteredPost(Integer userId);
}
