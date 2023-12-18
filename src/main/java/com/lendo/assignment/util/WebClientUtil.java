package com.lendo.assignment.util;

import com.lendo.assignment.exception.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class WebClientUtil<T> {

    private final WebClient webClient;


    public WebClientUtil() {
        this.webClient = WebClient.builder().build();
    }

    public Mono<T> get(String endpoint, Class<T> responseType) {
        return webClient.get()
                .uri(endpoint)
                .retrieve()
                .onStatus(httpStatus -> !httpStatus.is2xxSuccessful(),
                        clientResponse -> handleErrorResponse(HttpStatus.valueOf(clientResponse.statusCode().value())))
                .bodyToMono(responseType);
    }

    public Flux<T> getAll(String endpoint, Class<T> responseType) {
        return webClient.get()
                .uri(endpoint)
                .retrieve()
                .onStatus(httpStatus -> !httpStatus.is2xxSuccessful(),
                        clientResponse -> handleErrorResponse(HttpStatus.valueOf(clientResponse.statusCode().value())))
                .bodyToFlux(responseType);
    }

    public Mono<T> post(String endpoint, Object requestBody, Class<T> responseType) {
        return webClient.post()
                .uri(endpoint)
                .body(Mono.just(requestBody), requestBody.getClass())
                .retrieve()
                .onStatus(httpStatus -> !httpStatus.is2xxSuccessful(),
                        clientResponse -> handleErrorResponse(HttpStatus.valueOf(clientResponse.statusCode().value())))
                .bodyToMono(responseType);
    }

    private Mono<? extends Throwable> handleErrorResponse(HttpStatus statusCode) {
        // Handle non-success status codes here (e.g., logging or custom error handling)
        return Mono.error(new ServiceException("Failed to fetch data.", statusCode.toString()));
    }

}
