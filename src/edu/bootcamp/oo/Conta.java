package edu.bootcamp.oo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	List<Movimento> listaMovimentos = new ArrayList<>();

	protected int agencia;
	protected int numero;
	protected double saldo = 0;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) throws IOException {
		if(saldo >= valor) {
			saldo -= valor;
			Movimento operacao = new Movimento("SAQUE", valor);
			listaMovimentos.add(operacao);
		} else {
			throw new IOException("Não há saldo suficiente para o saque");
		}
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		Movimento operacao = new Movimento("DEPOSITO", valor);
		listaMovimentos.add(operacao);
	}

	@Override
	public void transferir(double valor, IConta contaDestino) throws IOException {
		if(saldo >= valor) {
			saldo -= valor;
			contaDestino.depositar(valor);
			Movimento operacao = new Movimento("TRANSFERENCIA", valor);
			listaMovimentos.add(operacao);
		} else {
			throw new IOException("Não há saldo suficiente para a transferência");
		}
	}
	
	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println("----------------------------------------------");
		System.out.println(String.format("Titular: %s", this.cliente.getNome().toUpperCase()));
		System.out.println(String.format("Agência: %d", this.agencia));
		System.out.println(String.format("Número Conta: %d", this.numero));
		System.out.println("----------------------------------------------");
	}
}