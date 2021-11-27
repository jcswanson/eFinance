package com.ist412.efinance.service;

import com.ist412.efinance.model.*;

import java.util.List;


public interface LoanService {

    List<Loan> getAllUserLoans(Integer ssn);
    List<Loan> getAllLoans();
    void saveLoan(Loan loan, User applicant);
    void saveAutoLoan(AutoLoan autoLoan);
    void savePersonalLoan(PersonalLoan personalLoan);
    void saveBusinessLoan(BusinessLoan businessLoan);
    Loan getLoanById(long loanId);
    void deleteLoanById(long loanId);
}
