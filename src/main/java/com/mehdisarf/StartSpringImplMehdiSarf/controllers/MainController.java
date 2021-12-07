package com.mehdisarf.StartSpringImplMehdiSarf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping("/home")
    public String home(@RequestParam String color, Model model) {
        // tells Spring it needs to get the value from the HTTP request parameter
        // with the same name as the method’s parameter name.

        model.addAttribute("color", color);
        model.addAttribute("username", "Qolam");

        return "home.html";
    }
}

