package com.emergon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticateController {

    @GetMapping("/loginPage")
    public String showLoginForm(){
        return "form-login";
    }
}
