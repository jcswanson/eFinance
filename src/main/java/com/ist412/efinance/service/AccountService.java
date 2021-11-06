package com.ist412.efinance.service;

import com.ist412.efinance.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
    void saveAccount(Account account);

}
