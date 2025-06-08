package com.model;

public class Test {
    public static void main(String[] args) {
        Cliente aroldo = new Cliente("Aroldo", "0123", 1500.00);
        Cliente gordola = new Cliente("Gordola", "0123444", 2500.00);

        Banco pica = new Banco("Banco", 10.0);
        Banco tenso = new Banco("Tenso",50.0);

        Emprestimo empDoGordola = new Emprestimo(gordola);

        empDoGordola.simularEmprestimo(tenso, 200, 5);
        empDoGordola.contratarEmprestimo();

        // gordola.verDadosEmprestimo();

        //fazer duas simulações diferentes e acionar contratarEmprestimo, depois, listas em Cliente, e em banco, para ver as informaçoes do empréstimo.
    }
}

