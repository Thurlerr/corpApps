package com.model;

public class Emprestimo {
    private Cliente cliente;
    private Banco banco;
    private double valorDesejado = 0.0;
    private int parcelas = 0;
    private double CET;
    private double taxaJurosMensal;
    private double valorParcelas;

//fluxo: instancia emprestimo, chama simularemprestimo. simularemprestimo chama calcularemprestimo
    public Emprestimo (Cliente cliente, Banco banco, double valorDesejado, int parcelas ){
        this.cliente = cliente;
        this.banco = banco;
        this.valorDesejado = valorDesejado;
        this.parcelas = parcelas;
    }

    public boolean calcularEmprestimo (){
    double txJurosAnual = banco.getTxJurosAnual();
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

    public void simularEmprestimo (){
        //essa taxa de juros anual tem que vir da escolha do banco
        
        if (!this.calcularEmprestimo()){
            return;
        }
        //exibir resultado
        System.out.println("Taxa de juros mensal: " + this.taxaJurosMensal*100);
        System.out.println("Custo Efetivo Total (CET): " + this.CET);
        System.out.println(this.parcelas + " parcelas de R$: " + this.valorParcelas);
    }

    public void contratarEmprestimo (double txJurosAnual){
        this.calcularEmprestimo();
        cliente.adicionarEmprestimo(this);
        
    }
    //essa é a função que deve ser chamada quando concordo com simular emprestimo. Ela deve utilizar os dados que foram passados no construtor e o calculo da simulação
}
