package edu.bootcamp.oo;

import java.io.IOException;

public interface IConta {
	void sacar(double valor) throws IOException;
	
	void depositar(double valor);
	
	void transferir(double valor, IConta contaDestino) throws IOException;
	
	void imprimirSaldo();
	
	void imprimirExtrato();
}