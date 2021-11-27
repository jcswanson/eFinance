package com.ist412.efinance.repository;

import com.ist412.efinance.model.Loan;

import javax.transaction.Transactional;

@Transactional
public interface LoanRepository extends LoanBaseRepository<Loan> {


}
