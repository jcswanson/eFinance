package com.ist412.efinance.controller;

import com.ist412.efinance.model.CustomUserDetails;
import com.ist412.efinance.repository.UserRepository;
import com.ist412.efinance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    private UserService userService;



    @GetMapping("/adminHome")
    public String adminHome(){
        return "admin/admin-home";
    }

    @RequestMapping(value="/adminLogout", method = RequestMethod.GET)
    public String adminLogoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "admin/admin-logout";
    }

    @GetMapping("/adminClients")
    public String adminClients(Model model){

        model.addAttribute("userList", userService.getAllUsers());

        return "admin/clients";
    }



}
