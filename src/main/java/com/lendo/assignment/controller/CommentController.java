package com.lendo.assignment.controller;

import com.lendo.assignment.model.CommentModel;
import com.lendo.assignment.model.PostModel;
import com.lendo.assignment.service.CommentService;
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

@Tag(name = "Comments", description = "Comment's APIs")
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @Operation(summary = "Retrieve all Comments")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = CommentModel.class), mediaType = "application/json") })})
    @GetMapping("/all")
    public ResponseEntity<List<CommentModel>> getAllComments() {

        return new ResponseEntity<>(commentService.getAllComments(), HttpStatus.OK);
    }

    @Operation(summary = "Filter Comments by PostId")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = CommentModel.class), mediaType = "application/json") }) })
    @GetMapping("/filter/{postId}")
    public ResponseEntity<List<CommentModel>> getPosts(@PathVariable("postId") Integer postId) {

        return new ResponseEntity<>(commentService.getFilteredComment(postId), HttpStatus.OK);
    }
}
