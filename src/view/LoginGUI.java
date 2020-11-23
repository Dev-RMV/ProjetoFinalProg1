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
	
	
	public LoginGUI() {
		setTitle("Login");
		setBounds(100, 100, 351, 302);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		txtNome = new JTextField();
		txtNome.setText("user");
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setBounds(72, 68, 201, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSenha.setBounds(72, 136, 201, 20);
		getContentPane().add(txtSenha);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(72, 43, 46, 14);
		getContentPane().add(lblNome);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(72, 111, 46, 14);
		getContentPane().add(lblSenha);
		
		btnEnviar = new JButton("ENVIAR");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = txtNome.getText();
				String senha = String.valueOf(txtSenha.getPassword());
				if(login.equals("") || senha.equals(""))
					JOptionPane.showMessageDialog(null, "Preencha os campos");
				else if(!login.equals("user") || !senha.equals("12345"))
					JOptionPane.showMessageDialog(null, "Login ou Passord inválidos!");
				else if (login.equals("user") && senha.equals("12345")) {
					MedicoGUI cadastro = new MedicoGUI(); 
					setVisible(false);
				}
			}
		});
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnviar.setBounds(54, 203, 107, 23);
		getContentPane().add(btnEnviar);
		
		btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtSenha.setText("");
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpar.setBounds(185, 203, 107, 23);
		getContentPane().add(btnLimpar);
		
		
		

	}
}
