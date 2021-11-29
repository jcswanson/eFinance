package com.ist412.efinance.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;

@Slf4j
@Data
@Entity
public class AutoLoan extends Loan implements Serializable{


    private String vinNumber;
    private String make;
    private String model;
    private Integer year;
    private Integer mileage;
    private Double engineSize;
    private Boolean isUsedCar;
    private String dealerName;



    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(Double engineSize) {
        this.engineSize = engineSize;
    }

    public Boolean getUsedCar() {
        return isUsedCar;
    }

    public void setUsedCar(Boolean usedCar) {
        isUsedCar = usedCar;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }
}
