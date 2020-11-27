package model;

public class Medico {
	private String nome;
	private long cpf;
	private String crm;
	private long telefone;
	private String especialidade;
	
	public Medico(String nome, long cpf, String crm, long telefone, String especialidade) {
		this.nome = nome;
		this.cpf = cpf;
		this.crm = crm;
		this.telefone = telefone;
		this.especialidade = especialidade;
	}
	
	public Medico() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public String toString(Medico m) {
		return m.toString();
		
	}
}
