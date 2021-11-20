package com.ist412.efinance.repository;

import com.ist412.efinance.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    @Override
    Optional<BankAccount> findById(Long id);
}
