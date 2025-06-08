package com.model;
import java.util.ArrayList;
import java.util.List;

public class Cliente { //adicionar data de nascimento e condição para verificar se soliciante é maior de 18 / e formatar data para padrão brasileiro
    public static int contadorId = 0; //amarrar no banco de dados
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

    
    // public String verDadosEmprestimo(){
    //     if (emprestimos.isEmpty()){
    //         System.out.println("Nenhum empréstimo registrado para o cliente.");
    //     }else{
    //         for (Emprestimo emp : emprestimos) {
    //             emp.getNomeBanco();
    //             emp.getValorDesejado();
    //             emp.getParcelas();
    //             emp.getCET();
    //             emp.getTaxaJurosMensal();
    //             emp.getValorParcelas();
    //         }
    //     }
    // }
    
    //getters
    public List<Emprestimo> getEmprestimos() {
        return this.emprestimos;
    }

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
