package com.mehdisarf.StartSpringImplMehdiSarf.controllers;

import com.mehdisarf.StartSpringImplMehdiSarf.LoggedUserManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final LoggedUserManagement loggedUserManagement;

    @Autowired
    public MainController(LoggedUserManagement loggedUserManagement) {
        this.loggedUserManagement = loggedUserManagement;
    }

    @RequestMapping(value = "/main")
    public String home(@RequestParam(required = false) String logout,
                       Model model) {

        if (logout != null) {
            loggedUserManagement.setUsername(null);
        }

        String username = loggedUserManagement.getUsername();

        // username should be different than null if someone logged in.
        if (username == null)
            return "redirect:/";

        model.addAttribute("username" , username);

        return "main.html";
    }
}
