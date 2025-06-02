package com.model;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    public static int contadorId = 0;
    private int id;
    private String nome = "";
    private String cpf = "";
    private double renda = 0.0;
    private boolean empAtivo = false;
    private List<Emprestimo> emprestimos;


    public Cliente (String nome, String cpf, double renda) {
        this.nome = nome;
        this.cpf = cpf;
        this.renda = renda;
        this.id = Cliente.contadorId;
        Cliente.contadorId = Cliente.contadorId + 1;
        this.emprestimos = new ArrayList<>();
    };

    public void adicionarEmprestimo (Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public int getId () {
        return this.id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public boolean isEmpAtivo() {
        return empAtivo;
    }

    public void setEmpAtivo(boolean empAtivo) {
        this.empAtivo = empAtivo;
    }
}
