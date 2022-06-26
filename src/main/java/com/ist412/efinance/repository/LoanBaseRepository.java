package com.ist412.efinance.repository;

import com.ist412.efinance.model.Loan;
import com.ist412.efinance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface LoanBaseRepository <T extends Loan>
        extends JpaRepository<T, Long>{


    T findBySocialSecurityNumber(Integer ssn);
    T findByLoanId(Long loanId);
    List<T> findAllBySocialSecurityNumber(Integer ssn);
    List<T> findByLoanStatus(String loan_status);


}
