package com.example.employee_management_system.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
    public HomeController() {

    }

    @GetMapping("/")
    public String index(Model model, Principal principal) {
        if (principal == null) {
            model.addAttribute("isEmpty", true);
        } else {
            model.addAttribute("isEmpty", false);
            model.addAttribute("nameOfUser", principal.getName());
        }
        return "index";
    }
}
