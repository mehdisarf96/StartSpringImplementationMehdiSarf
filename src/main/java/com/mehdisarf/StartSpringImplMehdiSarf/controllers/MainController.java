package com.mehdisarf.StartSpringImplMehdiSarf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // a stereotype annotation
public class MainController {

    @RequestMapping("/home") // associate the action with an HTTP request path.
    public String home() { // An action
        return "Hello.html"; // returns a reference to the web page the app returns in response.
    }
}