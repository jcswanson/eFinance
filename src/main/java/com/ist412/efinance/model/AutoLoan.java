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


}
