package controller;

import java.util.ArrayList;
import java.util.List;

import dao.MedicoDao;
import model.Medico;

public class MedicoController {
	
	public boolean cadastrar(String nome,long cpf,String crm, long telefone,String especialidade) {
		Medico m=new Medico(nome,cpf,crm,telefone,especialidade);
		MedicoDao mDao= new MedicoDao();
		return mDao.inserir(m);
	}
	
	public List<Medico> consultar(){
		List<Medico> medicos = new ArrayList<>();
		MedicoDao mDao= new MedicoDao();
		medicos=mDao.read();
		return medicos;
	}
}
