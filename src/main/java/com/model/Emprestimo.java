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
    }

    public void simularEmprestimo ( double txJurosAnual){
        //essa lógica de calculo pode estar dentro das regras de negócio do banco, e não precisa ser repetida aqui na parte de simulação?
        //essa taxa de juros anual tem que vir da escolha do banco
        double capacidadeDePagamento = cliente.getRenda() * 0.30;

        if (capacidadeDePagamento < this.valorDesejado){ //O empréstimo só é liberado para clientes que comprometam até 30% da renda.
            System.out.println("Valor desejado excede capacidade de pagamento com renda atual.");
        }
        //Valor total (CET) = valor desejado * (1 + (tx de juros mensal * parcelas))
        double taxaJurosMensal = (txJurosAnual/100)/12;
        double CET = this.valorDesejado * (1 + (taxaJurosMensal * this.parcelas));
        double valorParcelas = CET/this.parcelas;

        //exibir resultado
        System.out.println("Taxa de juros mensal:" + taxaJurosMensal*100);
        System.out.println("Custo Efetivo Total (CET): " + CET);
        System.out.println(this.parcelas + "parcelas de R$: " + valorParcelas);


    }

    cliente.adicionarEmprestimo(this); //usar o factory method do gpt ou achar outra forma de adicionar esse emprestimo a lista de clientes
}
