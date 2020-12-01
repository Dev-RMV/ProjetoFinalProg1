package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import dao.MedicoDao;
import model.Medico;
import view.MedicoGUI;

public class MedicoController {
	
	public boolean cadastrar(String nome,long cpf,String crm, long telefone,String especialidade) {
		Medico m=new Medico(nome,cpf,crm,telefone,especialidade);
		MedicoDao mDao= new MedicoDao();
		return mDao.inserir(m);
	}
	
	public static List<Medico> consultar(){
		List<Medico> medicos = new ArrayList<>();
		MedicoDao mDao= new MedicoDao();
		medicos=mDao.read();
		return medicos;
	}	
	
	public static int enviar(){
		String nome = MedicoGUI.getTxtNome().getText();
		long cpf = -666;
		String crm = MedicoGUI.getTxtCrm().getText();
		long telefone = -666;
		String especialidade = (String) MedicoGUI.getComboBoxEspecialidade().getSelectedItem();
		try{
			cpf = Long.parseLong(MedicoGUI.getTxtCpf().getText());
			telefone = Long.parseLong(MedicoGUI.getTxtTelefone().getText());
		}
		catch(Exception eInvalido){
			System.out.println("DESENVOLVIMENTO -> ERRO: "+eInvalido.getMessage());
			return 1;
		}
		if(nome.equals("")||cpf==-666||telefone==-666||crm.equals(""))
			return 2;
		else {
			try{
				MedicoController mControl=new MedicoController();
				mControl.cadastrar(nome,cpf,crm,telefone,especialidade);
				MedicoController.limpaCadastro();
				MedicoGUI.adicionarDados(consultar());
				return 3;
			}
			catch(Exception eErroCadastro) {
				System.out.println("DESENVOLVIMENTO -> ERRO: "+eErroCadastro.getMessage());
				return 4;
			}
		}
	}
	
	public static boolean deletar() {
		if (MedicoGUI.getTxtConsulta().getText().length()==0) {
			JOptionPane.showMessageDialog(null,"Digite no campo de consulta o CPF completo do Médico!");
			return false;
		}
		try{
			long cpfDao;
			cpfDao= Long.parseLong(MedicoGUI.getTxtConsulta().getText());
			int confirma=-1;
			confirma=JOptionPane.showConfirmDialog(null,"Está certo de que quer deletar o médico de CPF "+cpfDao+"? ESSA OPERAÇÃO NÃO PODE SER DESFEITA!");
			if (confirma==0) {
				MedicoDao.excluir(cpfDao);
				MedicoGUI.adicionarDados(consultar());
				return true;
			}
		}
		catch(Exception eCpf){
			JOptionPane.showMessageDialog(null,"CPF inválido!"+eCpf.getMessage());
		}
		return false;						
	}
	
	public static boolean alterar () {
		if (MedicoGUI.getTxtConsulta().getText().length()==0) {
			JOptionPane.showMessageDialog(null,"Digite no campo de consulta o CPF completo do Médico!");
			return false;
		}
		try{
			long cpfDao= Long.parseLong(MedicoGUI.getTxtConsulta().getText());
			if(MedicoDao.encontrarCpf(cpfDao)==true){
				String[] s = {"Cardiologista","Clínico geral","Dermatologista","Endocrinologista","Neurologista"};
				int r=JOptionPane.showOptionDialog(null,"Entre com a especialidade", "Especialidade", 0, 0, null, s, 0);
				String r2;
				if(r==1)
					r2=s[0];
				else if(r==2)
					r2=s[1];
				else if(r==3)
					r2=s[2];
				else r2=s[4];
				Medico mDao= new Medico(
					JOptionPane.showInputDialog("Entre com o novo Nome:"),
					Long.parseLong(JOptionPane.showInputDialog("Entre com o novo CPF:")),
					JOptionPane.showInputDialog("Entre com o novo CRM:"),
					Long.parseLong(JOptionPane.showInputDialog("Entre com o novo Telefone")),
					r2
				);
				MedicoDao.update(mDao,cpfDao);
				JOptionPane.showMessageDialog(null,"Dados alterados com sucesso!");
				MedicoGUI.adicionarDados(consultar());
				return true;
			};
		}
		catch(Exception eInvalido) {
			JOptionPane.showMessageDialog(null,"Dados inválidos ou não encontrados.");
		}
		return false;
	}
		
	public static void limpaCadastro() {
		MedicoGUI.getTxtCrm().setText("");
		MedicoGUI.getTxtCpf().setText("");
		MedicoGUI.getTxtTelefone().setText("");
		MedicoGUI.getTxtNome().setText("");	
	}
}