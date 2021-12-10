package com.ist412.efinance.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "bank_account")
public class BankAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_id")
    private Long bid;
    @Column(name = "first")
    private String firstName;
    @Column(name = "last")
    private String lastName;
    @Column(name = "bankName")
    private String bankName; //what is the name of the bank used
    @Column(name = "bankAccountNumber")
    private Long bankAccountNumber;
    @Column(name = "routingNumber")
    private Long routingNumber; //9 digit routing number
    @Column(name = "accountType")
    private String accountType;//checking, savings or other

    public BankAccount(){

    }

    //getters and setters


    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(Long bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public Long getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(Long routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
