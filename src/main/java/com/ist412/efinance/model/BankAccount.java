package com.ist412.efinance.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;

@Slf4j
@Entity
@Getter
@Setter
@Table(name = "bank_account")
public class BankAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bank_id")
    private long bid;
    @Column(name = "first")
    private String firstName;
    @Column(name = "last")
    private String lastName;
    @Column(name = "bankName")
    private String bankName; //what is the name of the bank used
    @Column(name = "bankAccountNumber")
    private int bankAccountNumber;
    @Column(name = "routingNumber")
    private int routingNumber; //9 digit routing number
    @Column(name = "accountType")
    private String accountType;//checking, savings or other

    public BankAccount(){

    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "newApplicant_id")
    private User newApplicant;

    @Override
    public String toString() {
        return "BankAccount{" +
                "bid=" + bid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankAccountNumber=" + bankAccountNumber +
                ", routingNumber=" + routingNumber +
                ", accountType='" + accountType + '\'' +
                '}';
    }


    //getters and setters


}

