package com.ist412.efinance.controller;


import com.ist412.efinance.model.User;
import com.ist412.efinance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepo;


    @GetMapping("/login")
    public String login(){
        return "login";

    }


    @GetMapping("/logout")
    public String logout(){
        return "logout";
    }
    @GetMapping("/userHome")
    public String userHome(){
        return "user-home";
    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "registration";

    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "redirect:/login";

    }


}