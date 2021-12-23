package com.ist412.efinance.controller;

import com.ist412.efinance.model.Plaid;
import com.ist412.efinance.service.PlaidServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class PlaidController {


    @Autowired
    private PlaidServiceImpl plaidService;

    @GetMapping("/plaidLink")
    public String showPlaidLink(Model model){
        Plaid plaids = new Plaid();
        model.addAttribute("linkView", plaids);

        return "plaid/plaid-link";

    }



}
