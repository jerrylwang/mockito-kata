package com.kata.controller;

import com.kata.service.MyService;
import com.kata.util.Request;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/myController")
public class MyController {

    private final MyService myService;
    private final Request request;
    public MyController(MyService myService, Request request) {
        this.myService = myService;
        this.request = request;
    }

    @GetMapping("")
    public ResponseEntity<String> callService() {
        HttpResponse<String> response;

        try {
            response = myService.send(request.requestBuilder());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok(response.body());
    }


}
