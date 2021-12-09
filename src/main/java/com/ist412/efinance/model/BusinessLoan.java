package com.ist412.efinance.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import java.io.Serializable;

@Slf4j
@Data
@Entity
public class BusinessLoan extends Loan implements Serializable {

    private String businessName;
    private String businessAddress;
    private int propertyCost;
    private int annualProfit;
    private boolean collateral;
    private int budget;

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public int getPropertyCost() {
        return propertyCost;
    }

    public void setPropertyCost(int propertyCost) {
        this.propertyCost = propertyCost;
    }

    public int getAnnualProfit() {
        return annualProfit;
    }

    public void setAnnualProfit(int annualProfit) {
        this.annualProfit = annualProfit;
    }

    public boolean isCollateral() {
        return collateral;
    }

    public void setCollateral(boolean collateral) {
        this.collateral = collateral;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }


}
