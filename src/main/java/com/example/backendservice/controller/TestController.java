package com.example.backendservice.controller;

import com.example.backendservice.domain.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public ResponseEntity<Response> getResponse(){
        return ResponseEntity.ok(new Response("test"));
    }
}
