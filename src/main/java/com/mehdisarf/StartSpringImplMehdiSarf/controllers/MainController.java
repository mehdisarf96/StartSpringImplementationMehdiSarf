package com.mehdisarf.StartSpringImplMehdiSarf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/home/{rang}")
    public String home(@PathVariable String rang, Model model) {
        // use the @PathVariable annotation to mark the controller’s action parameter
        // to get the path variable’s value.

        model.addAttribute("color", rang);
        model.addAttribute("username", "Qolam");

        return "home.html";
    }
}

