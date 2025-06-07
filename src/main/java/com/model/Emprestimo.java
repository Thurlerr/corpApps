package com.model;

public class Emprestimo {
    private final Cliente cliente;
    private Banco banco;
    private double valorDesejado = 0.0;
    private int parcelas = 0;
    private double CET;
    private double taxaJurosMensal;
    private double valorParcelas;

    //fluxo: instancia emprestimo, chama simularemprestimo. simularemprestimo chama calcularemprestimo
    public Emprestimo (Cliente cliente){
        this.cliente = cliente;
    }

    //retorna boolean para ser usada em simularEmprestimo, os calculos da função são acessados
    public boolean calcularEmprestimo (Banco banco, double valorDesejado, int parcelas){
        this.valorDesejado = valorDesejado;
        this.parcelas = parcelas;
        this.banco = banco;
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

    public void simularEmprestimo (Banco banco, double valorDesejado, int parcelas){        
        if (!this.calcularEmprestimo(banco, valorDesejado, parcelas)){ //se retornar true essa linha já chama o método
            return;
        }
        //exibir resultado
        System.out.println("Taxa de juros mensal: " + this.taxaJurosMensal*100);
        System.out.println("Custo Efetivo Total (CET): " + this.CET);
        System.out.println(this.parcelas + " parcelas de R$: " + this.valorParcelas);
    }
    //esse método "finaliza" a contratação do empréstimo, utilizando as ultimas sobrescritas dos atributos pela simulação para ser armazenada
    public void contratarEmprestimo (){
        if (this.valorDesejado == 0.0){
            System.out.println("Simulação não realizada");
        }
        cliente.adicionarEmprestimo(this);
        System.out.println("Empréstimo contratado!");
    }

    //getters
    public String getNomeBanco() {
        return banco.getNome();
    }

    public double getValorDesejado() {
        return valorDesejado;
    }

    public int getParcelas() {
        return parcelas;
    }

    public double getCET() {
        return CET;
    }

    public double getTaxaJurosMensal() {
        return taxaJurosMensal;
    }

    public double getValorParcelas() {
        return valorParcelas;
    }
}

//fazer duas simulações diferentes e acionar contratarEmprestimo, depois, listas em Cliente, e em banco, para ver as informaçoes do empréstimo.