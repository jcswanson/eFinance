package com.ist412.efinance.service;

import com.ist412.efinance.model.Loan;
import com.ist412.efinance.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    LoanRepository loanRepository;


    @Override
    public List<Loan> getAllLoans() {
        return this.loanRepository.findAll();
    }

    @Override
    public void saveLoan(Loan loan) {
        this.loanRepository.save(loan);
    }

    @Override
    public Loan getLoanById(long loanId) {
        Optional<Loan> optionalLoan = loanRepository.findById(loanId);
        Loan loan = null;
        if (optionalLoan.isPresent()){
            loan = optionalLoan.get();
        } else {
            throw new RuntimeException("Loan not found for ID:: " + loanId);
        }
        return loan;
    }


    @Override
    public void deleteLoanById(long loanId) {
        this.loanRepository.deleteById(loanId);
    }
}
