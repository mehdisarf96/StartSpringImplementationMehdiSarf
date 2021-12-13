package com.mehdisarf.StartSpringImplMehdiSarf.model;

import com.mehdisarf.StartSpringImplMehdiSarf.LoggedUserManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private String username;
    private String password;
    private LoggedUserManagement loggedUserManagement;

    @Autowired
    public LoginProcessor(LoggedUserManagement loggedUserManagement) {
        this.loggedUserManagement = loggedUserManagement;
    }


    public boolean login() {

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
