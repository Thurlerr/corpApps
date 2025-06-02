package com.model;

import java.util.List;
import java.util.ArrayList;

public class Banco {
    private String nome;
    private double txJurosAnual;
    private List<Emprestimo> emprestimo;
    
    public Banco (String nome, double txJurosAnual){
        this.nome = nome;
        this.txJurosAnual = txJurosAnual;
        this.emprestimo = new ArrayList<>();
    }

    public void adicionarEmprestimo (Emprestimo emprestimo){
        this.emprestimo.add(emprestimo);
    }

    public String getNome() {
        return nome;
    }
    
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public double getTxJurosAnual() {
        return txJurosAnual;
    }
    
    
    public void setTxJurosAnual(double txJurosAnual) {
        this.txJurosAnual = txJurosAnual;
    }
}
