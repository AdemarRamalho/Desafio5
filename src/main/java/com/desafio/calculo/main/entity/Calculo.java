package com.desafio.calculo.main.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calculo {
    private int count;
    private double mediana;
    private double media;
    private double desvioPadrao;
    private double valorMinimo;
    private double valorMaximo;
    private double soma;

}
