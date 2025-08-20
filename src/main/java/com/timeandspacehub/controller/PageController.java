package com.timeandspacehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome"; // maps to welcome.html
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // maps to login.html
    }

    @GetMapping("/logout-success")
    public String logoutPage() {
        return "logout"; // maps to logout.html
    }
}

