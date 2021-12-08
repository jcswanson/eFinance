package com.ist412.efinance.controller;


import com.ist412.efinance.model.User;
import com.ist412.efinance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepo;


    @GetMapping("/login")
    public String login(){
        return "login";

    }

    @GetMapping("/admin")
    public String adminHome(){
        return "admin/admin-home";
    }
//    @GetMapping("/logout")
//    public String logout(){
//        return "logout";
//    }



    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "logout";
    }

    @GetMapping("/userHome")
    public String userHome(){

        return "User/user-home";

        return "user/user-home";

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