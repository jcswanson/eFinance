package com.ist412.efinance.model;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class PersonalLoan extends Loan implements Serializable {


    private String loanPurpose;
    private int loanAmount;
    private int termInYears;





}
