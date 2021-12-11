package com.mehdisarf.StartSpringImplMehdiSarf.controllers;

import com.mehdisarf.StartSpringImplMehdiSarf.model.LoginProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private LoginProcessor loginProcessor;

    @Autowired
    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginGet() {
        return "login.html";
    }

    // same path but with different method.
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String loginPost(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {

        // validation process
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password); // farz kon dar hamin lahze ye user dg
        // mikhad log in kone. vaqti flow, baraye un mirese be in Controller,
        // va mikhad constructor DI anjam bede, farz kon age moqeye autowired
        // referenceii be hamun instance qabli e LoginProcessor ro barmigardund be onvane
        // arguman e constructor, unvaqt vaqti flow miresid be in 2 khat bala, tamame
        // etelaate avali az beyn miraft va override mishod.
        // yani amalan yejur race shekl migereft sare un tak-instance va un tak-instance
        // mishod resource e moshtarak.

        boolean loggedIn = loginProcessor.authenticate();

        if (loggedIn) {
            model.addAttribute("message", "You are now logged in.");
        } else {
            model.addAttribute("message", "Login failed!");
        }

        return "login.html";
    }
}