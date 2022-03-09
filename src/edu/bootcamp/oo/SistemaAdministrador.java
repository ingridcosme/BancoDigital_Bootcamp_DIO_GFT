package edu.bootcamp.oo;

import javax.swing.JOptionPane;

public class SistemaAdministrador {
	
	public void MenuAdministrador(Banco banco) {
		
		int opc = 0;
		while(opc != 9) {
			String opcao = JOptionPane.showInputDialog(null, menu());
			opc = Integer.parseInt(opcao);
			switch(opc) {
			
			case 1:
				banco.setNome(JOptionPane.showInputDialog("Digite o nome do Banco"));
				break;
			
			case 2:
				Cliente cliente1 = new Cliente();
				cliente1.setNome(JOptionPane.showInputDialog("Digite o nome do Cliente"));
				cliente1.setCpf(Long.parseLong(JOptionPane.showInputDialog("Digite o CPF de " + cliente1.getNome())));
				Conta cCorrente = new ContaCorrente(cliente1);
				JOptionPane.showMessageDialog(null, "Conta Corrente Aberta com Sucesso!\n" 
												+ "\n Titular: " + cliente1.getNome()
												+ "\n CPF: " + cliente1.getCpf()
												+ "\n Agência " + cCorrente.getAgencia()
												+ "\n Número Conta " + cCorrente.getNumero());
				banco.adicionarContaNaLista(cCorrente);
				break;
			
			case 3:
				Cliente cliente2 = new Cliente();
				cliente2.setNome(JOptionPane.showInputDialog("Digite o nome do Cliente"));
				cliente2.setCpf(Long.parseLong(JOptionPane.showInputDialog("Digite o CPF de " + cliente2.getNome())));
				Conta cPoupanca = new ContaPoupanca(cliente2);
				JOptionPane.showMessageDialog(null, "Conta Poupanca Aberta com Sucesso!\n" 
												+ "\n Titular: " + cliente2.getNome()
												+ "\n CPF: " + cliente2.getCpf()
												+ "\n Agência " + cPoupanca.getAgencia()
												+ "\n Número Conta " + cPoupanca.getNumero());
				banco.adicionarContaNaLista(cPoupanca);
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
		buffer.append("=== SISTEMA BANCÁRIO ===\n");
		buffer.append("\nEscolha uma opção\n");
		buffer.append("1 - Incluir Banco\n");
		buffer.append("2 - Abrir Conta Corrente\n");
		buffer.append("3 - Abrir Conta Poupança\n");
		buffer.append("9 - Voltar ao menu anterior\n");

		return buffer.toString();
	}
	

}