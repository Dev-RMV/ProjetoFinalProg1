package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.LoginController;

public class LoginGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static JTextField txtNome;
	private static JPasswordField txtSenha;
	private JButton btnLimpar;
	private JButton btnEnviar;
	private JLabel lblLogin;
	private JLabel lblSenha;
	
	
	public LoginGUI() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		setTitle("Login");
		setBounds(100, 100, 287, 238);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		txtNome = new JTextField();
		txtNome.setToolTipText("user ou sa");
		txtNome.setText("user");
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setBounds(25, 39, 224, 25);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setToolTipText("12345 é o padrão");
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSenha.setBounds(25, 107, 224, 25);
		getContentPane().add(txtSenha);
		
		lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogin.setBounds(25, 11, 46, 25);
		getContentPane().add(lblLogin);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(25, 82, 46, 25);
		getContentPane().add(lblSenha);
		
		btnEnviar = new JButton("ENVIAR");
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnviar.setBounds(25, 154, 107, 23);
		getContentPane().add(btnEnviar);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (LoginController.validaLogin()==true) {
					dispose();
				}					
			}
		});
		
		btnLimpar = new JButton("LIMPAR");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpar.setBounds(142, 154, 107, 23);
		getContentPane().add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginController.limpaLogin();
			}
		});

	}

	public static JTextField getTxtNome() {
		return txtNome;
	}

	public static JPasswordField getTxtSenha() {
		return txtSenha;
	}
}