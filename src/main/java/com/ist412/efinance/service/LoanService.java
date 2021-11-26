package com.ist412.efinance.service;

import com.ist412.efinance.model.AutoLoan;
import com.ist412.efinance.model.BusinessLoan;
import com.ist412.efinance.model.Loan;
import com.ist412.efinance.model.PersonalLoan;

import java.util.List;


public interface LoanService {

    List<Loan> getAllUserLoans(Integer ssn);
    List<Loan> getAllLoans();
    void saveLoan(Loan loan);
    void saveAutoLoan(AutoLoan autoLoan);
    void savePersonalLoan(PersonalLoan personalLoan);
    void saveBusinessLoan(BusinessLoan businessLoan);
    Loan getLoanById(long loanId);
    void deleteLoanById(long loanId);
}
