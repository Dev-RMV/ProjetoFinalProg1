package controller;

import javax.swing.JOptionPane;

import view.LoginGUI;
import view.MedicoGUI;

public class LoginController {
	
	public static void limpaLogin() {
		LoginGUI.getTxtNome().setText("");
		LoginGUI.getTxtSenha().setText("");
	}
	
	public static boolean validaLogin() {
		String login = LoginGUI.getTxtNome().getText();
		String senha = String.valueOf(LoginGUI.getTxtSenha().getPassword());
		if(login.equals("") || senha.equals(""))
			JOptionPane.showMessageDialog(null, "Preencha os campos");
		else if(!(login.equals("sa") || login.equals("user")) || !senha.equals("12345"))
			JOptionPane.showMessageDialog(null, "Login ou Passord inválidos!");
		else if ((login.equals("sa")||login.equals("user")) && senha.equals("12345")) {
			//Assim que é validado o Login, é feita uma consulta para
			//colocar o que está no BD na tela, já q são poucos dados.
			try{
				MedicoGUI cadastro = new MedicoGUI();
				MedicoController mControl=new MedicoController();
				cadastro.adicionarDados(mControl.consultar());
				return true;				
			}
			catch(Exception eD){
				JOptionPane.showMessageDialog(null, "Erro desconhecido! Info:\n"+eD.getMessage());
			}
		}
		return false;		
	}
}
