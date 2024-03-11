// 1 - Pacote
package br.com.iterasys;
// 2 - Importação de bibliotecas

// 3 - Classe
public class Encomenda {
    // 3.1 Atributos

    // 3.2 Função e Metodo

    public static int calcularBarrasDeChocolatesPorCaixa(int barras){
        byte quantidadePorCaixa = 12;
        int caixas = barras / quantidadePorCaixa;
        int unidades = barras % quantidadePorCaixa;
        System.out.println("Quantidade de Caixas: " + caixas);
        System.out.println("Uidades: " + unidades);
        return caixas;

    } // fim calcularBarrasDeChocolatesPorCaixa

} //fim da classe Encomenda
