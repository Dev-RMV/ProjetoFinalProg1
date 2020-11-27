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

import controller.MedicoController;

public class LoginGUI extends JFrame {
	private JTextField txtNome;
	private JPasswordField txtSenha;
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
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = txtNome.getText();
				String senha = String.valueOf(txtSenha.getPassword());
				if(login.equals("") || senha.equals(""))
					JOptionPane.showMessageDialog(null, "Preencha os campos");
				else if(!(login.equals("sa") || login.equals("user")) || !senha.equals("12345"))
					JOptionPane.showMessageDialog(null, "Login ou Passord inválidos!");
				else if ((login.equals("sa")||login.equals("user")) && senha.equals("12345")) {
					//Assim que é validado o Login, é feita uma consulta para
					//colocar o que está no BD na tela, já q são poucos dados.
					try{
						MedicoGUI cadastro = new MedicoGUI();
						MedicoController mControl=new MedicoController();
						cadastro.adicionarDados(mControl.consultar());
						dispose();	
					}
					catch(Exception eD){
						JOptionPane.showMessageDialog(null, "Erro desconhecido! Info:\n"+eD.getMessage());
					}
				}
			}
		});
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnviar.setBounds(25, 154, 107, 23);
		getContentPane().add(btnEnviar);
		
		btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtSenha.setText("");
			}
		});
		
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpar.setBounds(142, 154, 107, 23);
		getContentPane().add(btnLimpar);

	}


}
