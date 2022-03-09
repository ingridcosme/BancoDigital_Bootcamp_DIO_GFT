package edu.bootcamp.oo;

import javax.swing.JOptionPane;

public class SistemaBancario {

	public static void main(String[] args) {
		SistemaAdministrador menu1 = new SistemaAdministrador();
		DadosConta menu2 = new DadosConta();
		Banco banco = new Banco();
		
		int opc = 0;
		while(opc != 9) {
			String opcao = JOptionPane.showInputDialog(null, menu());
			opc = Integer.parseInt(opcao);
			switch(opc) {
			
			case 1:
				menu1.MenuAdministrador(banco);
				break;
			
			case 2:
				menu2.MenuDadosConta(banco);
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
		buffer.append("1 - Acessar como administrador\n");
		buffer.append("2 - Acessar como cliente\n");
		buffer.append("9 - Finalizar Sistema\n");

		return buffer.toString();
	}

}