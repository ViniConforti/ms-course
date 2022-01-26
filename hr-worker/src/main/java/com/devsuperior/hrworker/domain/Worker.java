package com.devsuperior.hrworker.domain;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
// Anotacao do Lombok que gera get and setters, hash e por ai vai
@Data
//Cria o construtor com os argumentos  utilizando o lombok
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "tb_worker")
public class Worker implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double dailyIncome;
}
