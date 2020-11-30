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
		String cpfDel ="";
		cpfDel=MedicoGUI.getTxtConsulta().getText();
		if (cpfDel.length()==0) {
			JOptionPane.showMessageDialog(null,"Digite no campo de consulta o CPF completo do Médico!");
			return false;
		}
		try{
			int confirma=-1;
			confirma=JOptionPane.showConfirmDialog(null,"Está certo de que quer deletar o médico de CPF "+cpfDel+"? ESSA OPERAÇÃO NÃO PODE SER DESFEITA!");
			long cpfDelDao;
			cpfDelDao= Long.parseLong(cpfDel);
			if (confirma==0) {
				MedicoDao.excluir(cpfDelDao);
				MedicoGUI.adicionarDados(consultar());;
				return true;
			}
		}
		catch(Exception eCpf){
			JOptionPane.showMessageDialog(null,"CPF inválido!"+eCpf.getMessage());
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
