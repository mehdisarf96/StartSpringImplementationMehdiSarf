package com.mehdisarf.StartSpringImplMehdiSarf.controllers;

import com.mehdisarf.StartSpringImplMehdiSarf.LoggedUserManagement;
import com.mehdisarf.StartSpringImplMehdiSarf.LoginCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final LoggedUserManagement loggedUserManagement;
    private final LoginCounter loginCounter;

    @Autowired
    public MainController(LoggedUserManagement loggedUserManagement, LoginCounter loginCounter) {
        this.loggedUserManagement = loggedUserManagement;
        this.loginCounter = loginCounter;
    }

    @RequestMapping(value = "/main")
    public String home(
            @RequestParam(required = false) String logout,
            Model model) {

        if (logout != null) {
            loggedUserManagement.setUsername(null);
        }

        String username = loggedUserManagement.getUsername();
        long count = loginCounter.getCounter();

        // username should be different than null if someone logged in.
        if (username == null)
            return "redirect:/";

        model.addAttribute("username", username);
        model.addAttribute("loginCount", count);

        return "main.html";
    }
}
