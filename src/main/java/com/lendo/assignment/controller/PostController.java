package com.lendo.assignment.controller;

import com.lendo.assignment.model.PostModel;
import com.lendo.assignment.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Posts", description = "Post's APIs")
@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Operation(summary = "Retrieve all Posts")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = PostModel.class), mediaType = "application/json") }) })
    @GetMapping("/all")
    public ResponseEntity<List<PostModel>> getPosts() {

        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @Operation(summary = "Filter Posts by UserId")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = PostModel.class), mediaType = "application/json") }) })
    @GetMapping("/filter/{userId}")
    public ResponseEntity<List<PostModel>> getPosts(@PathVariable("userId") Integer userId) {

        return new ResponseEntity<>(postService.getFilteredPost(userId), HttpStatus.OK);
    }
}
