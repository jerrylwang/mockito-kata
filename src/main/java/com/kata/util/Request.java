package com.kata.util;

import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpRequest;
@Component
public class Request {
    public HttpRequest requestBuilder () {
        return HttpRequest.newBuilder().uri(URI.create("http://localhost:8080")).GET().build();

    }
}
