package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionFactory {
	private static String url="jdbc:sqlserver://localhost;databaseName=Prog1";
	private static String userName = "sa";
	private static String password = "12345";
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url,userName,password);
		} 
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao conectar o Banco de Dados!\n"+ e.getMessage());
		}
		return null;
	}
	
	public static void closeConnection(Connection con) {
		if (con!=null) {
			try {
				con.close();
			} 
			catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"Erro ao finalizar a conexão com o Banco de Dados!\n"+ e.getMessage());
			}
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt) {
		if (stmt!=null) {
			try {
				con.close();
			} 
			catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"Erro ao finalizar a conexão com o Banco de Dados!\n"+ e.getMessage());
			}
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		if (rs!=null) {
			try {
				con.close();
			} 
			catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"Erro ao finalizar a conexão com o Banco de Dados!\n"+ e.getMessage());
			}
		}
	}
	
	
}
	
