package com.metacoding.bankv1.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccontController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
