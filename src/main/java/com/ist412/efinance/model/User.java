package com.ist412.efinance.model;

import com.plaid.client.model.CountryCode;
import com.plaid.client.model.LinkTokenCreateRequest;
import com.plaid.client.model.LinkTokenCreateRequestUser;
import com.plaid.client.model.Products;
import com.plaid.client.request.PlaidApi;
import lombok.*;
import lombok.extern.slf4j.Slf4j;


import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Slf4j
@Entity
@Table(name = "users")
@Getter
@Setter
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long uid;

    @Column(name = "first", nullable = false, length = 45)
    private String firstName;

    @Column(name = "last", nullable = false, length = 45)
    private String lastName;

    @Column(name = "email", unique = true, length = 45)
    private String emailAddress;

    @Column(name = "phone_num", length = 10)
    private String phoneNumber;

    @Column(name = "dob", length = 10)
    private String dateOfBirth;

    @Column(name = "address", length = 75)
    private String address;

    @Column(name = "state", length = 25)
    private String state;

    @Column(name = "zip_code", length = 5)
    private String zipCode;

    @Column(name = "username", unique = true, nullable = false, length = 45)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", length = 25)
    private String role = "ROLE_USER";

    @Column(name = "enabled")
    private boolean enabled = true;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "applicant", orphanRemoval = true)

    private List<Loan> loans = new ArrayList<>();

    public void addLoan(Loan loan){
        loan.setApplicant(this);
        this.loans.add(loan);
    }

    public void removeLoan(Loan loan){
        loan.setApplicant(null);
        this.loans.remove(loan);
    }

    public void removeLoans(){
        Iterator<Loan> iterator = this.loans.iterator();
        while(iterator.hasNext()){
            Loan loan = iterator.next();
            loan.setApplicant(null);
            iterator.remove();
        }
    }





    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "newApplicant", orphanRemoval = true)

    private List<BankAccount> bankAccounts = new ArrayList<>();

    public void addBankAccount(BankAccount bankAccount){
        bankAccount.setNewApplicant(this);
        this.bankAccounts.add(bankAccount);


    }

//    @OneToMany(cascade = CascadeType.ALL,
//            mappedBy = "plaidApplicant", orphanRemoval = true)
//
//    private List<Plaid> plaids = new ArrayList<>();


    @Override
    public String toString() {
        return "User{" +
                "userID=" + uid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", username= '" + username + '\'' +
                ", role= '" + role + '\'' +
                '}';
    }
}
