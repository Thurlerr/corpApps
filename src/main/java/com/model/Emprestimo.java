package com.model;

public class Emprestimo {
    private Cliente cliente;
    private double valorDesejado = 0.0;
    private int parcelas = 0;
    private double CET;
    private double taxaJurosMensal;
    private double valorParcelas;

//fluxo: instancia emprestimo, chama simularemprestimo. simularemprestimo chama calcularemprestimo
    public Emprestimo (Cliente cliente, double valorDesejado, int parcelas ){
        this.cliente = cliente;
        this.valorDesejado = valorDesejado;
        this.parcelas = parcelas;
    }

    public boolean calcularEmprestimo (double txJurosAnual){
      //  banco.txJurosAnual //ainda não existe
    double capacidadeDePagamento = cliente.getRenda() * 0.30;

    if (capacidadeDePagamento < this.valorDesejado){ //O empréstimo só é liberado para clientes que comprometam até 30% da renda.
            System.out.println("Valor de emprestimo desejado excede capacidade de pagamento com renda atual do cliente.");
            return false;
    }
    //Valor total (CET) = valor desejado * (1 + (tx de juros mensal * parcelas))
    this.taxaJurosMensal = (txJurosAnual/100)/12;
    this.CET = this.valorDesejado * (1 + (this.taxaJurosMensal * this.parcelas));
    this.valorParcelas = this.CET/this.parcelas;
    return true;
    }

    public void simularEmprestimo (double txJurosAnual){
        //essa taxa de juros anual tem que vir da escolha do banco
        
        if (!this.calcularEmprestimo(txJurosAnual)){
            return;
        }
        //exibir resultado
        System.out.println("Taxa de juros mensal: %.2f%%" + this.taxaJurosMensal*100);
        System.out.println("Custo Efetivo Total (CET): " + this.CET);
        System.out.println(this.parcelas + " parcelas de R$: " + this.valorParcelas);
    }

    public void contratarEmprestimo (double txJurosAnual){
        this.calcularEmprestimo(txJurosAnual);
        cliente.adicionarEmprestimo(this);
    }
    //essa é a função que deve ser chamada quando concordo com simular emprestimo. Ela deve utilizar os dados que foram passados no construtor e o calculo da simulação
}
