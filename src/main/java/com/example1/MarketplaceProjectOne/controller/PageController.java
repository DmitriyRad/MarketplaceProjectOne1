package com.example1.MarketplaceProjectOne.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

@RestController
@RequestMapping("/")
public class PageController {

    @GetMapping("/")
    public String home() {
        return "Hello Word!";
    }




}
