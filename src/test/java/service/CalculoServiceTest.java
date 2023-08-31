package service;

import com.desafio.calculo.main.entity.Calculo;
import com.desafio.calculo.main.service.CalculoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = CalculoService.class)
public class CalculoServiceTest {
    private CalculoService calculoService = new CalculoService();

    @Test
    public void testCauculoPar(){
        List<Double> numeros = Arrays.asList(10.0,20.0,30.0,40.0);
        Calculo calculo = calculoService.calcular(numeros);

        assertEquals(4,calculo.getCount(),0.01);
        assertEquals(25.0,calculo.getMedia(),0.01);
        assertEquals(25.0,calculo.getMediana(),0.01);
        assertEquals(11.18,calculo.getDesvioPadrao(),0.01);
        assertEquals(10.0,calculo.getValorMinimo(),0.01);
        assertEquals(40.0,calculo.getValorMaximo(),0.01);
        assertEquals(100.0,calculo.getSoma(),0.01);
    }
    @Test
    public void testCauculoImpar(){
        List<Double> numeros = Arrays.asList(10.0,20.0,30.0);
        Calculo calculo = calculoService.calcular(numeros);

        assertEquals(3,calculo.getCount(),0.01);
        assertEquals(20.0,calculo.getMedia(),0.01);
        assertEquals(20.0,calculo.getMediana(),0.01);
        assertEquals(8.16,calculo.getDesvioPadrao(),0.1);
        assertEquals(10.0,calculo.getValorMinimo(),0.01);
        assertEquals(30.0,calculo.getValorMaximo(),0.01);
        assertEquals(60.0,calculo.getSoma(),0.01);
    }
}
