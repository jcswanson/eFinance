package com.ist412.efinance.repository;

import com.ist412.efinance.model.Account;
import com.ist412.efinance.service.AccountService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Override
    Optional<Account> findById(Long id);




}