package com.mehdisarf.StartSpringImplMehdiSarf.model;

import com.mehdisarf.StartSpringImplMehdiSarf.LoggedUserManagement;
import com.mehdisarf.StartSpringImplMehdiSarf.LoginCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private String username;
    private String password;
    private final LoggedUserManagement loggedUserManagement;
    private final LoginCounter loginCounter;

    @Autowired
    public LoginProcessor(LoggedUserManagement loggedUserManagement, LoginCounter loginCounter) {
        this.loggedUserManagement = loggedUserManagement;
        this.loginCounter = loginCounter;
    }


    public boolean login() {

        loginCounter.increment();

        boolean loginResult = false;

        if ("mehdi".equals(username) && "123".equals(password)) {
            loginResult = true;
            loggedUserManagement.setUsername(username);
        }

        return loginResult;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
