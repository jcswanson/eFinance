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
    private String bankname; //what is the name of the bank used
    @Column(name = "bankAccountnumber")
    private Long bankAccountnumber;
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

    public Long getBankAccountnumber() {
        return bankAccountnumber;
    }

    public void setBankAccountnumber(Long bankaccountnumber) {
        this.bankAccountnumber = bankaccountnumber;
    }

    public Long getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(Long routingnumber) {
        this.routingNumber = routingnumber;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
