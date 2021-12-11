package com.ist412.efinance.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Slf4j
@Entity
@Data
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Loan  implements Serializable{

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

    @Column(name = "interest_rate ")
    private Double interestRate;

    @Column(name = "term_in_months", length = 4)
    private Integer loanTermInMonths;

    @Column(name = "loan_amount", length = 25)
    private Double loanAmount;

    @Column(name = "loan_status", nullable = false, length = 12)
    private String loanStatus;

    @Column(name = "signature")
    private String signature;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_id")
    private User applicant;


    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return loanId != null && loanId.equals(((User) obj).getUid());
        }

    @Override
    public int hashCode() {
        return Objects.hash(loanId);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId= " + loanId +
                ", socialSecurityNumber= " + socialSecurityNumber +
                ", applicant= " + applicant +
                ", loanAmount= " + loanAmount +
                '}';
    }
}

