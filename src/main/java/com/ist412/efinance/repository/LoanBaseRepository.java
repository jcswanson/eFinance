package com.ist412.efinance.repository;

import com.ist412.efinance.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface LoanBaseRepository <T extends Loan>
        extends JpaRepository<T, Long>{

    public T findBySocialSecurityNumber(Integer ssn);
    public T findByLoanId(Long loanId);
    public List<T> findAllBySocialSecurityNumber(Integer ssn);
}
