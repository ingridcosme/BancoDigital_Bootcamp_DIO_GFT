package edu.bootcamp.oo;

import java.util.List;

public class Movimento {
	private String tipo;
	private double valor;
	
	public Movimento(String tipo, double valor) {
		this.tipo = tipo;
		this.valor = valor;
	}
	
	public static void imprimirMovimentacao(List<Movimento> operacoes, double saldo) {
		System.out.println(String.format("%15s %26s", "MOVIMENTO", "VALOR"));
		System.out.println("----------------------------------------------");
		
		for(Movimento m : operacoes) {
			if(m.getTipo().equals("SAQUE") || m.getTipo().equals("TRANSFERENCIA")) {
				System.out.format("%15s %28.2f", m.getTipo(), m.getValor() * -1);
			} else {
				System.out.format("%15s %28.2f", m.getTipo(), m.getValor());
			}
            System.out.println();
		}
		
		System.out.println("----------------------------------------------");
		System.out.println(String.format("Saldo %28.2f", saldo));
		System.out.println("----------------------------------------------");
	}

	public String getTipo() {
		return tipo;
	}

	public double getValor() {
		return valor;
	}

}