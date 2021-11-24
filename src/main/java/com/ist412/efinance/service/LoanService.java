package com.ist412.efinance.service;

import com.ist412.efinance.model.Loan;

import java.util.List;


public interface LoanService {

    List<Loan> getAllLoans();
    void saveLoan(Loan loan);
    Loan getLoanById(long loanId);
    void deleteLoanById(long loanId);
}
