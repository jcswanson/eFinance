package com.ist412.efinance.repository;

import com.ist412.efinance.model.AutoLoan;

import javax.transaction.Transactional;

@Transactional
public interface AutoLoanRepository extends LoanBaseRepository<AutoLoan> {

}
