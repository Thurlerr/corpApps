package com.model;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    public static int contadorId = 0;
    private final int id;
    private String nome = "";
    private String cpf = "";
    private double renda = 0.0;
    private final boolean empAtivo = false; //não é usado?
    private final List<Emprestimo> emprestimos;


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
        return this.emprestimos;
    }

    public void verDadosEmprestimo(){
        if (emprestimos.isEmpty()){
            System.out.println("Nenhum empréstimo registrado para o cliente.");
        }else{
            for (Emprestimo emp : emprestimos) {
                System.out.println(emp.getNomeBanco());
                System.out.println(emp.getValorDesejado());
                System.out.println(emp.getParcelas());
                System.out.println(emp.getCET());
                System.out.println(emp.getTaxaJurosMensal());
                System.out.println(emp.getValorParcelas());
            }
        }

    }

    //getters
    public int getId () {
        return this.id;
    }
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public double getRenda() {
        return renda;
    }
    public boolean isEmpAtivo() {
        return empAtivo;
    }
}
