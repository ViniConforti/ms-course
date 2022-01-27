package com.devsuperior.hrpayroll.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Payment implements Serializable {
    private String name;
    private Double dailyIncome;
    private int days;


    public Double getTotal(){
        return this.dailyIncome * this.days;
    }

}
