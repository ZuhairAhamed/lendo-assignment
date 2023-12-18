package com.lendo.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostModel {

    private Integer id;

    private Integer user_id;

    private String title;

    private String body;
}
