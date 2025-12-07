package com.example.SiteOfRsvp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String test() {
        return "✅ TEST ENDPOINT - Hello World!";
    }

    @GetMapping("/order/9")
    public String orderTest() {
        return "✅ ORDER 9 ENDPOINT - Success!";
    }
}
