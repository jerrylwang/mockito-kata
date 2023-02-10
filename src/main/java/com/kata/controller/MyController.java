package com.kata.controller;

import com.kata.service.MyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/myController")
public class MyController {

    private final MyService myService;
    private final HttpRequest httpRequest;

    public MyController(MyService myService, HttpRequest httpRequest) {
        this.myService = myService;
        this.httpRequest = httpRequest;
    }

    @GetMapping("")
    public ResponseEntity<String> callService() {
        HttpResponse<String> response;

        try {
            response = myService.send(httpRequest);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok(response.body());
    }
}
