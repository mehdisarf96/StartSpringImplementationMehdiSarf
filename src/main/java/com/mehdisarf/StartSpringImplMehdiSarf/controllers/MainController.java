package com.mehdisarf.StartSpringImplMehdiSarf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/home")
    public String home(Model model) {

        model.addAttribute("username", "Qolam");
        model.addAttribute("color", "red");

        return "home.html";
    }
}

