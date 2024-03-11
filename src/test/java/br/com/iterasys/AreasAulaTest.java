package br.com.iterasys;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AreasAulaTest {


    @Test
    public void testarCalcularQuadrado (){
        double lado = 3;
        double resultadoEsperado = 9;
        double resultadoAtual = AreasAula.calcularQuadrado(lado);
        Assert.assertEquals(resultadoAtual, resultadoEsperado);
    }
}
