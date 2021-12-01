package com.ist412.efinance.controller;

import com.ist412.efinance.model.BankAccount;
import com.ist412.efinance.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BankAccountController
{
    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping("/showNewBankAccountForm")
    public String showNewBankAccountForm(Model model) {
        BankAccount bankAccount = new BankAccount();
        model.addAttribute("bank_account", bankAccount);
        return "new_bank_account";
    }
    @PostMapping("/saveBankAccount")
    public String saveBankAccount(@ModelAttribute("bank_account") BankAccount bankAccount) {
        bankAccountService.saveBankAccount(bankAccount);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") long id, Model model) {
        BankAccount bankAccount = bankAccountService.getBankAccountById(id);
        model.addAttribute("bank_account", bankAccount);
        return "update_bank_account";
    }
    @GetMapping("/deleteBankAccount/{id}")
    public String deleteBankAccount(@PathVariable(value = "id") long id) {
        this.bankAccountService.deleteBankAccountById(id);
        return "redirect:/";
    }

}
