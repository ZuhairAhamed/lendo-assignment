package com.lendo.assignment.service.implementation;

import com.lendo.assignment.model.UserModel;
import com.lendo.assignment.service.UserService;
import com.lendo.assignment.util.WebClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Value("${url.user}")
    private String url;

    @Autowired
    private WebClientUtil webClientUtil;

    @Override
    public List<UserModel> getAllUsers() {

        Flux<UserModel> userModelFlux = webClientUtil.getAll(url, UserModel.class);
        return userModelFlux.collectList().block();

    }

}
