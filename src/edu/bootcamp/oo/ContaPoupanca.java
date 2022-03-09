package edu.bootcamp.oo;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirSaldo() {
		System.out.println("====== SALDO CONTA POUPANCA ======");
		super.imprimirInfosComuns();
		System.out.println(String.format("Saldo %28.2f", this.saldo));
		System.out.println("----------------------------------------------");
		System.out.println("\n");
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("====== EXTRATO CONTA POUPANCA ======");
		super.imprimirInfosComuns();
		Movimento.imprimirMovimentacao(this.listaMovimentos, this.saldo);
		System.out.println("\n");
	}
	
}