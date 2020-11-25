package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.Medico;

public class MedicoDao {
	
	public boolean inserir (Medico m) {
		Connection con = null;
		PreparedStatement stmt= null;
		ResultSet rs = null;
		String sqlInsert="insert into ProjetoFinal(CPF,Nome,CRM,Especialidade,Telefone) values (?,?,?,?,?)";
		
		//Print de teste no console para fins de desenvolvimento:
		//Checando o valor dos atributos q são passados ao BD
		System.out.println("**DESENVOLVIMENTO** CPF:"+m.getCpf());
		System.out.println("**DESENVOLVIMENTO** NOME:"+m.getNome());
		System.out.println("**DESENVOLVIMENTO** CRM:"+m.getCrm());
		System.out.println("**DESENVOLVIMENTO** ESPECIALIDADE:"+m.getEspecialidade());
		System.out.println("**DESENVOLVIMENTO** TELEFONE:"+m.getTelefone());
		//Fim dos prints no console
		
		con=ConnectionFactory.getConnection();
		
		try {
			stmt=con.prepareStatement(sqlInsert);
			stmt.setLong(1, m.getCpf());
			stmt.setString(2, m.getNome());
			stmt.setString(3, m.getCrm());
			stmt.setString(4, m.getEspecialidade());
			stmt.setLong(5, m.getTelefone());
			stmt.execute();
			return true;
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro no cadastro do Médico!", "Erro", 2);
			return false;
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
