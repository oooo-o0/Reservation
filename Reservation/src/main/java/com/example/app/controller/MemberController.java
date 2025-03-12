package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.Member;
import com.example.app.validation.LoginGroup;
import com.example.app.validation.RegisterGroup;

@Controller
public class MemberController {
    @GetMapping("/register")
    public String registerGet(Model model) {
        model.addAttribute("member", new Member());
        return "register";
    }
    @PostMapping("/register")
    public String registerPost(@Validated (RegisterGroup.class) Member member, Errors errors) {
        if (!member.getEmail().equals(member.getEmailConf())) {
            errors.rejectValue("emailConf", "error.email.inequal");
        }
        if(errors.hasErrors()) {
            return "register";
        }
        return "registerDone";
    }
    @GetMapping("/login")
    public String loginGet(Model model) {
        model.addAttribute("loginMember", new Member());
        return "login";
    }
    @PostMapping("/login")
    public String loginPost(
        @Validated(LoginGroup.class) 
        @ModelAttribute("loginMember") Member loginMember, Errors errors) {
        if(errors.hasErrors()) {
            return "login";
        }
        if (!loginMember.getEmail().equals("taro@example.com")
                || !loginMember.getPassword().equals("abc")) {
            errors.reject("error.wrong_id_or_password");
        }
        return "loginDone";
    }
    
}
