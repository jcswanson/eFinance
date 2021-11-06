package com.ist412.efinance.service;

import com.ist412.efinance.model.Account;
import com.ist412.efinance.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts() {
        return this.accountRepository.findAll();

    }

    @Override
    public void saveAccount(Account account) {
        this.accountRepository.save(account);
    }
}
