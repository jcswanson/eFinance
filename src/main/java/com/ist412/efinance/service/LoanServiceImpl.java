package com.ist412.efinance.service;

import com.ist412.efinance.model.AutoLoan;
import com.ist412.efinance.model.BusinessLoan;
import com.ist412.efinance.model.Loan;
import com.ist412.efinance.model.PersonalLoan;
import com.ist412.efinance.repository.AutoLoanRepository;
import com.ist412.efinance.repository.BusinessLoanRepository;
import com.ist412.efinance.repository.LoanRepository;
import com.ist412.efinance.repository.PersonalLoanRepository;
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

    @Override
    public List<Loan> getAllUserLoans(Integer userId) {
        List<Loan> loans = new ArrayList<>();
        loanRepository.findAllBySocialSecurityNumber(userId)
                .forEach(loans::add);
        return loans;
    }

    @Override
    public List<Loan> getAllLoans() {
        return this.loanRepository.findAll();
    }

    @Override
    public void saveLoan(Loan loan) {
        this.loanRepository.save(loan);
    }

    @Override
    public void saveAutoLoan(AutoLoan autoLoan) {
        this.autoLoanRepository.save(autoLoan);

    }

    @Override
    public void savePersonalLoan(PersonalLoan personalLoan) {
        this.personalLoanRepository.save(personalLoan);
    }

    @Override
    public void saveBusinessLoan(BusinessLoan businessLoan) {
        this.businessLoanRepository.save(businessLoan);
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
