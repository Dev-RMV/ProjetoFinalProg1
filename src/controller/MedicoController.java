package controller;

import dao.MedicoDao;
import model.Medico;

public class MedicoController {
	
	public boolean cadastrar(String nome,long cpf,String crm, long telefone,String especialidade) {
		Medico m=new Medico(nome,cpf,crm,telefone,especialidade);
		MedicoDao mDao= new MedicoDao();
		return mDao.inserir(m);
	}
		

}
