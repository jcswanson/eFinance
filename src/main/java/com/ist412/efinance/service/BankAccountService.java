package com.ist412.efinance.service;

import com.ist412.efinance.model.BankAccount;
import com.ist412.efinance.model.User;

import java.util.List;

public interface BankAccountService {
    List<BankAccount> getAllBankAccounts();
    List<BankAccount> getAllUserBankAccounts(User user);
    void saveBankAccount(BankAccount bankAccount, User newApplicant);
    BankAccount getBankAccountById(long id);
    void deleteBankAccountById(long id);
}
