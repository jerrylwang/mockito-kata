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

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("")
    public ResponseEntity<String> callService() {
        HttpRequest request = HttpRequest.newBuilder().build();
        HttpResponse<String> response;

        try {
            response = myService.send(request);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok(response.body());
    }
}
