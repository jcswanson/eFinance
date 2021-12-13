package com.ist412.efinance.service;

import com.ist412.efinance.model.BankAccount;
import com.ist412.efinance.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountServiceImpl implements BankAccountService
{
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public List<BankAccount> getAllBankAccounts() {

        return this.bankAccountRepository.findAll();
    }

    @Override
    public void saveBankAccount(BankAccount bankAccount){this.bankAccountRepository.save(bankAccount);}

    @Override
    public BankAccount getBankAccountById(long id)
    {
        Optional<BankAccount> optional = bankAccountRepository.findById(id);
        BankAccount bankAccount = null;
        if(optional.isPresent()) {
            bankAccount = optional.get();
        }
        else{
            throw new RuntimeException("Bank Account not found for id :: " + id);
        }
        return bankAccount;

    }
    @Override
    public void deleteBankAccountById(long id){
        this.bankAccountRepository.deleteById(id);
    }


}
