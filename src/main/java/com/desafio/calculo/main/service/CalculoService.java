package com.desafio.calculo.main.service;

import com.desafio.calculo.main.entity.Calculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Long.sum;

@Service
@AllArgsConstructor
public class CalculoService {
    public Calculo calcular (List<Double> numeros){
        int count = numeros.size();
        double soma = numeros.stream().mapToDouble(Double::doubleValue).sum();
        double media = soma / count;

        List<Double> orgNumeros = numeros.stream().sorted().collect(Collectors.toList());

        double mediana;
        if(count % 2 == 0){
            mediana = (orgNumeros.get(count / 2-1)+  orgNumeros.get( count/2))/2;
        }else {
            mediana = orgNumeros.get(count/2);
        }

        double diffSoma = numeros.stream().mapToDouble(num ->Math.pow(num - media,2)).sum();
        double desvioPadrao = Math.sqrt(diffSoma/count);

        double valorMinimo = orgNumeros.get(0);
        double valorMaximo = orgNumeros.get(count-1);

        return new Calculo(count,mediana,media,desvioPadrao,valorMinimo,valorMaximo,soma);
    }
}
