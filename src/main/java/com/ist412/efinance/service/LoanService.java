package com.ist412.efinance.service;

import com.ist412.efinance.model.*;

import java.util.List;


public interface LoanService {

    List<Loan> getAllUserLoans(User user);
    List<Loan> getAllLoans();
    List<Loan> getAllAcceptedLoans();
    List<Loan> getAllDeniedLoans();
    void saveLoan(Loan loan, User applicant);
    Loan getLoanById(long loanId);
    void deleteLoanById(long loanId);
    void adminSaveLoan(Loan loan);
    void saveLoanByID(long loanId);
}
