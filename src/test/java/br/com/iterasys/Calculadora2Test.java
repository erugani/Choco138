package br.com.iterasys;

import juntos.Calculadora2;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Calculadora2Test {
    @Test
    public void testSomar(){
        double num1 = 5;
        double num2 = 7;

        double resultadoEsperado = 12;

        double resultadoAtual = Calculadora2.somar(num1, num2);

        Assert.assertEquals (resultadoAtual, resultadoEsperado);

    }
}
