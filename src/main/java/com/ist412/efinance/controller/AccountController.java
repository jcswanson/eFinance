package com.ist412.efinance.controller;

import com.ist412.efinance.model.Account;
import com.ist412.efinance.repository.AccountRepository;
import com.ist412.efinance.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/showNewAccountForm")
    public String showNewAccountForm(Model model){
        Account account = new Account();
        model.addAttribute("account", account);
        return "new_account";

    }

    @PostMapping("/saveAccount")
    public String saveAccount(@ModelAttribute("account") Account account){
        accountService.saveAccount(account);

        return "redirect:/login";

    }





}
