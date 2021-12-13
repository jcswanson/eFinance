package com.ist412.efinance.controller;

import com.ist412.efinance.model.BankAccount;
import com.ist412.efinance.model.User;
import com.ist412.efinance.repository.BankAccountRepository;
import com.ist412.efinance.repository.UserRepository;
import com.ist412.efinance.service.BankAccountService;
import com.ist412.efinance.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class BankAccountController
{
    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    CustomUserDetailsService customUserDetailsService;



    @GetMapping("/showNewBankAccountForm")
    public String showNewBankAccountForm(Model model) {
        BankAccount bankAccount = new BankAccount();
        model.addAttribute("bank_account", bankAccount);
        return "bankAccount/new_bank_account";
    }
//    @PostMapping("/saveBankAccount")
//    public String saveBankAccount(@ModelAttribute("bank_account") BankAccount bankAccount) {
//        bankAccountService.saveBankAccount(bankAccount);
//        return "redirect:/";
//    }
    @PostMapping("/saveBankAccount")
    public String saveBankAccount(@ModelAttribute("bank_account") BankAccount bankAccount, Errors errors,
                                  Principal principal) {

        User NewApplicant = customUserDetailsService.getUserByPrincipal(principal);
        this.bankAccountService.saveBankAccount(bankAccount, NewApplicant);
        this.bankAccountService.getAllBankAccounts();
        return "bankAccount/user_bank_account";

    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") long id, Model model) {
        BankAccount bankAccount = bankAccountService.getBankAccountById(id);
        model.addAttribute("bank_account", bankAccount);
        return "bankAccount/update_bank_account";
    }
    @GetMapping("/deleteBankAccount/{id}")
    public String deleteBankAccount(@PathVariable(value = "id") long id) {
        this.bankAccountService.deleteBankAccountById(id);
        return "redirect:/";
    }



    @GetMapping("/userBankAccounts")
    public String userBankAccounts(Model model, Principal principal){

        model.addAttribute("getUserBankAccounts", bankAccountService.getAllUserBankAccounts(customUserDetailsService.getUserByPrincipal(principal)));

        return "bankAccount/user_bank_account";
    }

}
