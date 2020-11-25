package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginGUI extends JFrame {
	private JTextField txtNome;
	private JPasswordField txtSenha;
	private JButton btnLimpar;
	private JButton btnEnviar;
	private JLabel lblNome;
	private JLabel lblSenha;
	private JTextField txtUrlDb;
	
	
	public LoginGUI() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		setTitle("Login");
		setBounds(100, 100, 416, 331);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setBounds(108, 117, 201, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSenha.setBounds(108, 185, 201, 20);
		getContentPane().add(txtSenha);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(108, 92, 46, 14);
		getContentPane().add(lblNome);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(108, 160, 46, 14);
		getContentPane().add(lblSenha);
		
		btnEnviar = new JButton("ENVIAR");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = txtNome.getText();
				String senha = String.valueOf(txtSenha.getPassword());
				if(login.equals("") || senha.equals(""))
					JOptionPane.showMessageDialog(null, "Preencha os campos");
				else if(!login.equals("sa") || !senha.equals("12345"))
					JOptionPane.showMessageDialog(null, "Login ou Passord inválidos!");
				else if (login.equals("sa") && senha.equals("12345")) {
					MedicoGUI cadastro = new MedicoGUI(); 
					setVisible(false);
				}
			}
		});
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnviar.setBounds(90, 252, 107, 23);
		getContentPane().add(btnEnviar);
		
		btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtSenha.setText("");
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpar.setBounds(221, 252, 107, 23);
		getContentPane().add(btnLimpar);
		
		JLabel lblUrlDb = new JLabel("URL do DB");
		lblUrlDb.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUrlDb.setBounds(142, 35, 157, 14);
		getContentPane().add(lblUrlDb);
		
		txtUrlDb = new JTextField();
		txtUrlDb.setText("jdbc:sqlserver://localhost:1433;databaseName=prog1");
		txtUrlDb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUrlDb.setColumns(10);
		txtUrlDb.setBounds(10, 61, 379, 20);
		getContentPane().add(txtUrlDb);
		
		
		

	}


	public JTextField getTxtUrlDb() {
		return txtUrlDb;
	}

}
