package com.ist412.efinance.service;

import com.ist412.efinance.model.*;
import com.ist412.efinance.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    LoanRepository loanRepository;
    @Autowired
    AutoLoanRepository autoLoanRepository;
    @Autowired
    PersonalLoanRepository personalLoanRepository;
    @Autowired
    BusinessLoanRepository businessLoanRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<Loan> getAllUserLoans(User user) {
        //doesn't work for some reason
        return userRepository.getById(user.getUid()).getLoans();
    }

    @Override
    public List<Loan> getAllLoans() {
        return this.loanRepository.findAll();
    }

    @Override
    public void saveLoan(Loan loan, User applicant)
    {

        applicant.addLoan(loan);
        loan.setApplicant(applicant);
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

    @Override
    public void adminSaveLoan(Loan loan) {
        this.loanRepository.save(loan);
    }

    @Override
    public void saveLoanByID(long loanId) {
        Optional<Loan> optionalLoan = loanRepository.findById(loanId);
        Loan loan = null;
        if (optionalLoan.isPresent()){
            loan = optionalLoan.get();
        } else {
            throw new RuntimeException("Loan not found for ID:: " + loanId);
        }

        this.loanRepository.save(loan);
    }

    @Override
    public List<Loan> getAllAcceptedLoans() {
        return loanRepository.findByLoanStatus("APPROVED");

    }

    @Override
    public List<Loan> getAllDeniedLoans() {
        return loanRepository.findByLoanStatus("DENIED");
    }
}
