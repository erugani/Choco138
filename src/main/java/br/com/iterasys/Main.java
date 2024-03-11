package br.com.iterasys;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        chamarEncomenda();
        calculadora.somarInteiros(5,7);
        calculadora.subtrairInteiros(7,5);
        calculadora.multiplicarInteiros(7,5);
        calculadora.divisaoInteiros(15,3);
    }
    public static void chamarEncomenda(){
        int barras = 80;
        Encomenda.calcularBarrasDeChocolatesPorCaixa(20);
        }
    }
