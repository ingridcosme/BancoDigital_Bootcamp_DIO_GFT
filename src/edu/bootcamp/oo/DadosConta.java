package edu.bootcamp.oo;

import javax.swing.JOptionPane;

public class DadosConta {
	
	public void MenuDadosConta(Banco banco) {
		
		int agencia = Integer.parseInt(JOptionPane.showInputDialog(
							"=== ACESSO CLIENTE ===\n" + "\n Informe a AGÊNCIA"));
		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog(
							"=== ACESSO CLIENTE ===\n" + "\n Informe o número da CONTA"));
		
		abrirSistemaCliente(banco, agencia, numeroConta);
		
	}

	private void abrirSistemaCliente(Banco banco, int agencia, int numeroConta) {
		SistemaCliente menu = new SistemaCliente();
		
		for(Conta conta : banco.getContas()) {
			if(conta.getAgencia() == agencia && conta.getNumero() == numeroConta) {
				menu.MenuCliente(banco, conta);
			} else {
				JOptionPane.showMessageDialog(null, "Conta não encontrada");
			}
		}
	}

}