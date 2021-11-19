package com.ist412.efinance.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Loan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "loan_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @Column(name = "ssn", length = 9)
    private Integer socialSecurityNumber;

    @Column(length = 45)
    private String employer;

    @Column(name = "job_title", length = 45)
    private String jobTitle;

    @Column(name = "annual_salary", length = 15)
    private Integer annualSalaryAmount;

    // Create a new class for cosigner information?
    //private UsersCosigner cosigner;

    @Column(name = "interest_rate ", length = 10)
    private Double interestRate;

    @Column(name = "term_in_months", length = 4)
    private Integer loanTermInMonths;

    @Column(name = "loan_amount", length = 25)
    private Double loanAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_id")
    private User applicant;
}

