package com.ist412.efinance.repository;

import com.ist412.efinance.model.BankAccount;
import com.ist412.efinance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

//    @Override
//    Optional<BankAccount> findById(Long bid);

    @Query("SELECT u FROM BankAccount u WHERE u.bid = ?1")
    Optional<BankAccount> findById(long bid);

}
