package com.model;

public class Emprestimo {
    private Cliente cliente;
    private double valorDesejado = 0.0;
    private int parcelas = 0;
    private double valorFinal;

    public Emprestimo (Cliente cliente, double valorDesejado, int parcelas ){
        this.cliente = cliente;
        this.valorDesejado = valorDesejado;
        this.parcelas = parcelas;
        //retornar o valor?
    }

    //colocar a lógica de calculo de simulação de empréstimo aqui

    cliente.adicionarEmprestimo(this); //usar o factory method do gpt pois ele ainda não está calculado
}
