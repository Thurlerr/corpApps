package com.model;

import java.util.ArrayList;
import java.util.List;

public class Banco { //talvez nem todo o sistema deveria ter acesso, colocar para package?
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
        return this.nome;
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
