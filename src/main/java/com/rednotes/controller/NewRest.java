package com.rednotes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewRest {
    @GetMapping("/lol")
    public int newnew(){
        int a = 11;
        return a;
    }
}
