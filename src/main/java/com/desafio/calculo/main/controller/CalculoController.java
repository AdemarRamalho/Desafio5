package com.desafio.calculo.main.controller;

import com.desafio.calculo.main.entity.Calculo;
import com.desafio.calculo.main.entity.RequisicaoNumeros;
import com.desafio.calculo.main.service.CalculoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class CalculoController {
    private final CalculoService calculoService;

    @PostMapping("/calcular")
    public ResponseEntity<?> calculo (@RequestBody RequisicaoNumeros requisicao){
        if(requisicao.getNumeros()==null || requisicao.getNumeros().size()<20){
            String errorMessage = "tem que inserir no minimo 20 números";
            return ResponseEntity.badRequest().body(errorMessage);
        }
        Calculo calculo = calculoService.calcular(requisicao.getNumeros());
        return ResponseEntity.ok(calculo);
    }
}
