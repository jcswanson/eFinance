package com.ist412.efinance.repository;

import com.ist412.efinance.model.PersonalLoan;

import javax.transaction.Transactional;

@Transactional
public interface PersonalLoanRepository extends LoanBaseRepository<PersonalLoan> {
}
