package com.lendo.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentModel {

    private Integer id;

    private Integer post_id;

    private String name;

    private String email;

    private String body;
}
