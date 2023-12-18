package com.lendo.assignment.service;

import com.lendo.assignment.model.UserModel;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserService {

    Flux<UserModel> getAllUsers();

}
