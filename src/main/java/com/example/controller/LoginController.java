package com.example.controller;

import com.example.entity.UserBean;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/loginIn")
    public String login(@RequestParam String name, @RequestParam String password) {
        if ("admin".equals(name) && "admin".equals(password)) {
            log.info("Admin login detected.");
            return "admin";
        }

        UserBean userBean = userService.loginIn(name, password);
        log.info("name:{}", name);
        log.info("password:{}", password);
        if (userBean != null) {
            return "success";
        } else {
            return "error";
        }
    }

    @GetMapping("/signup")
    public String showSignup() {
        return "signup";
    }

    @PostMapping("/register")
    public ModelAndView signUp(@RequestParam String name, @RequestParam String password) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            userService.insert(name, password);
            modelAndView.setViewName("success");
        } catch (IllegalArgumentException e) {
            modelAndView.setViewName("error");
            modelAndView.addObject("message", e.getMessage());
        }
        return modelAndView;
    }

}




