package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.Medico;

public class MedicoDao {
	
	public boolean inserir (Medico m) {
		Connection con = null;
		PreparedStatement stmt= null;
		String sqlInsert="insert into ProjetoFinal(CPF,Nome,CRM,Especialidade,Telefone) values (?,?,?,?,?)";
		
		//Print de teste no console para fins de desenvolvimento:
		//Checando o valor dos atributos q são passados ao BD
		System.out.println("\n\n**DESENVOLVIMENTO** CPF:"+m.getCpf());
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
			JOptionPane.showMessageDialog(null, "Erro no cadastro do Médico! Provavelmente já existe.", "Erro", 2);
			return false;
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	public List<Medico> read(){
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List <Medico> medicos = new ArrayList<>();
		String sqlConsulta = "select * from ProjetoFinal";
		try {
			stmt = con.prepareStatement(sqlConsulta);
			rs=stmt.executeQuery();
			while(rs.next()) {
				Medico m = new Medico();
				m.setCpf(rs.getLong("CPF"));
				m.setNome(rs.getString("Nome"));
				m.setCrm(rs.getString("CRM"));
				m.setEspecialidade(rs.getString("Especialidade"));
				m.setTelefone(rs.getLong("Telefone"));
				medicos.add(m);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro na consulta "+e.getMessage());
		}
		finally{
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return medicos;
	}
	
	public static void excluir (long cpfDao) {
		Connection con = null;
		PreparedStatement stmt= null;
		String sqlDelete="select * from ProjetoFinal; delete from ProjetoFinal where CPF="+cpfDao;
		con=ConnectionFactory.getConnection();
		
		try {
			if (encontrarCpf(cpfDao)) {
				stmt=null;
				stmt=con.prepareStatement(sqlDelete);
				stmt.execute();
				stmt.close();
				JOptionPane.showMessageDialog(null, "Sucesso na exclusão!");
			}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro na exclusão do Médico!"+e.getMessage(), "Erro", 2);
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}	
	public static boolean encontrarCpf(long cpfDao) {
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement stmt= null;
		ResultSet rs = null;
		String sqlEncontraCpf="select * from ProjetoFinal where CPF="+cpfDao;
		try {
			stmt=con.prepareStatement(sqlEncontraCpf);
			rs=stmt.executeQuery();
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Dados encontrados!");
				stmt.close();
				stmt=null;
				return true;
			}
			else JOptionPane.showMessageDialog(null, "Dados não encontrados...");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro na busca!"+e.getMessage(), "Erro", 2);
			return false;
		}
		finally {
			ConnectionFactory.closeConnection(con);
		}
		return false;
	}
	
	public static boolean update (Medico m, long cpfDao) {
		Connection con = null;
		PreparedStatement stmt= null;
		String sqlUpdate="update ProjetoFinal set CPF=?,Nome=?,CRM=?,Especialidade=?,Telefone=? where CPF="+cpfDao;
		
		//Print de teste no console para fins de desenvolvimento:
		//Checando o valor dos atributos q são passados ao BD
		System.out.println("\n\n**DESENVOLVIMENTO** CPF: "+m.getCpf());
		System.out.println("**DESENVOLVIMENTO** NOME: "+m.getNome());
		System.out.println("**DESENVOLVIMENTO** CRM: "+m.getCrm());
		System.out.println("**DESENVOLVIMENTO** ESPECIALIDADE: "+m.getEspecialidade());
		System.out.println("**DESENVOLVIMENTO** TELEFONE: "+m.getTelefone());
		System.out.println("**DESENVOLVIMENTO** CpfDao: "+cpfDao);
		//Fim dos prints no console
		
		con=ConnectionFactory.getConnection();
		
		try {
			stmt=con.prepareStatement(sqlUpdate);
			stmt.setLong(1, m.getCpf());
			stmt.setString(2, m.getNome());
			stmt.setString(3, m.getCrm());
			stmt.setString(4, m.getEspecialidade());
			stmt.setLong(5, m.getTelefone());
			stmt.execute();
			return true;
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar Médico!"+e.getMessage(), "Erro", 2);
			return false;
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}