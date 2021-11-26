package com.ist412.efinance.model;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "bank_account")
public class BankAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long uid;
    @Column(name = "first")
    private String firstName;
    @Column(name = "last")
    private String lastName;
    @Column(name = "bankname")
    private String bankname; //what is the name of the bank used
    @Column(name = "bankaccountnumber")
    private Long bankaccountnumber;
    @Column(name = "routingnumber")
    private Long routingnumber; //9 digit routing number
    @Column(name = "accounttype")
    private String accounttype;//checking, savings or other

    public BankAccount(){

    }

    //getters and setters

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
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

    public Long getBankaccountnumber() {
        return bankaccountnumber;
    }

    public void setBankaccountnumber(Long bankaccountnumber) {
        this.bankaccountnumber = bankaccountnumber;
    }

    public Long getRoutingnumber() {
        return routingnumber;
    }

    public void setRoutingnumber(Long routingnumber) {
        this.routingnumber = routingnumber;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }
}
