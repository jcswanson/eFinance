package com.ist412.efinance.repository;

import com.ist412.efinance.model.BusinessLoan;

import javax.transaction.Transactional;

@Transactional
public interface BusinessLoanRepository extends LoanBaseRepository<BusinessLoan> {
}
