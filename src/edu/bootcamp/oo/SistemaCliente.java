package edu.bootcamp.oo;

import java.io.IOException;

import javax.swing.JOptionPane;

public class SistemaCliente {
	
	public void MenuCliente(Banco banco, Conta conta) {
		double valor;
		int agencia, numeroConta;
		
		int opc = 0;
		while(opc != 9) {
			String opcao = JOptionPane.showInputDialog(null, menu());
			opc = Integer.parseInt(opcao);
			switch(opc) {
			
			case 1:
				conta.imprimirSaldo();
				break;
			
			case 2:
				conta.imprimirExtrato();
				break;
			
			case 3:
				try {
					valor = Double.parseDouble(JOptionPane.showInputDialog("=== ACESSO CLIENTE ===\n\n Informe o valor para sacar"));
					conta.sacar(valor);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			
			case 4:
				valor = Double.parseDouble(JOptionPane.showInputDialog("=== ACESSO CLIENTE ===\n\n Informe o valor do depósito"));
				conta.depositar(valor);
				break;
			
			case 5:
				try {
					agencia = Integer.parseInt(JOptionPane.showInputDialog("=== ACESSO CLIENTE ===\n\n Informe a AGÊNCIA da conta destino"));
					numeroConta = Integer.parseInt(JOptionPane.showInputDialog("=== ACESSO CLIENTE ===\n\n Informe o NÚMERO da conta destino"));
					
					Conta contaDestino = banco.consultarConta(agencia, numeroConta);
					if(contaDestino != null) {
						valor = Double.parseDouble(JOptionPane.showInputDialog("=== ACESSO CLIENTE ===\n\n Informe o valor"));
						conta.transferir(valor, contaDestino);
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
				
			case 9: 
				break;
			
			default:
				JOptionPane.showMessageDialog(null, "Digite uma opção válida", "ERRO", JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
		
	}
	
	private static String menu() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("=== SISTEMA CLIENTE ===\n");
		buffer.append("\nEscolha uma opção\n");
		buffer.append("1 - Consultar Saldo\n");
		buffer.append("2 - Obter Extrato\n");
		buffer.append("3 - Efetuar Saque\n");
		buffer.append("4 - Efetuar Depósito\n");
		buffer.append("5 - Realizar Transferência\n");
		buffer.append("9 - Voltar ao menu anterior\n");

		return buffer.toString();
	}

}