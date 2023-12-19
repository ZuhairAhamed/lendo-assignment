package com.lendo.assignment.config;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthRequestDTO {

    private String username;

    private String password;
}
