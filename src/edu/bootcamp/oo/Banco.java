package edu.bootcamp.oo;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private String nome;
	private List<Conta> contas;
	
	public Banco() {
		this.contas = new ArrayList<>();
	}
	
	public void adicionarContaNaLista(Conta conta) {
		this.contas.add(conta);
	}
	
	public Conta consultarConta(int agencia, int numeroConta) {
		Conta contaConsultada = null;
		for(Conta conta : this.contas) {
			if(conta.getAgencia() == agencia && conta.getNumero() == numeroConta) {
				contaConsultada = conta;
			}
		}
		return contaConsultada;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
}