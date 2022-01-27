package com.devsuperior.hrpayroll.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// Anotacao do Lombok que gera get and setters, hash e por ai vai
@Data
//Cria o construtor com os argumentos  utilizando o lombok
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Worker implements Serializable {

    private Long id;
    private String name;
    private Double dailyIncome;
}
