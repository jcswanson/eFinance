package com.ist412.efinance.service;


import com.ist412.efinance.model.BankAccount;
import java.util.List;

public interface BankAccountService {
    List<BankAccount> getAllBankAccounts();
    void saveBankAccount(BankAccount bankAccount);
    BankAccount getBankAccountById(long id);
    void deleteBankAccountById(long id);
}