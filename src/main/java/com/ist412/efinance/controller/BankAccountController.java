package com.ist412.efinance.controller;

import com.ist412.efinance.model.BankAccount;
import com.ist412.efinance.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;
    /*
    //Display List of courses
    @GetMapping("/bank_account")
    public String viewHomePage(Model model) {
        model.addAttribute("listBankAccount", bankAccountService.getAllBankAccounts());
        return "/bank_account";
    }

     */

    @GetMapping("/showNewBankAccountForm")
    public String showNewCourseForm(Model model) {
        //create model attribute to bind form data
        BankAccount bankAccount = new BankAccount();
        model.addAttribute("bank_account", bankAccount);
        return "/bank_account/new_bank_account";
    }

    @PostMapping("/saveBankAccount")
    public String saveCourse(@ModelAttribute("bank_account") BankAccount bankAccount) {
        //save bank account to database
        bankAccountService.saveBankAccount(bankAccount);
        return "redirect:/login";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        //get course from the service
        BankAccount bankAccount = bankAccountService.getBankAccountById(id);

        //set course as a model attribute to pre-populate the form
        model.addAttribute("bank_account", bankAccount);
        return "/bank_account/update_bank_account";
    }

    @GetMapping("/deleteBankAccount/{id}")
    public String deleteCourse(@PathVariable(value = "id") long id) {
        //call delete course method
        this.bankAccountService.deleteBankAccountById(id);
        return "redirect:/login";
    }
}