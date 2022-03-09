package edu.bootcamp.oo;

public class ContaCorrente extends Conta {
	
	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirSaldo() {
		System.out.println("====== SALDO CONTA CORRENTE ======");
		super.imprimirInfosComuns();
		System.out.println(String.format("Saldo %28.2f", this.saldo));
		System.out.println("----------------------------------------------");
		System.out.println("\n");
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("====== EXTRATO CONTA CORRENTE ======");
		super.imprimirInfosComuns();
		Movimento.imprimirMovimentacao(this.listaMovimentos, this.saldo);
		System.out.println("\n");
	}
	
	
}