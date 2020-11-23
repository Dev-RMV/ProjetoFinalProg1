package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MedicoGUI extends JFrame {
	private JTextField txtCrm;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtTelefone;
	private JLabel lblCrm;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JLabel lblEspecialidade;
	private JLabel lblTelefone;
	private JButton btnLimpar;
	private JButton btnEnviar;
	private JComboBox comboBoxEspecialidade;
	
	public MedicoGUI() {
		setBounds(100, 100, 418, 336);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
		
		txtCrm = new JTextField();
		txtCrm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCrm.setBounds(71, 33, 264, 20);
		getContentPane().add(txtCrm);
		txtCrm.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setColumns(10);
		txtNome.setBounds(71, 80, 264, 20);
		getContentPane().add(txtNome);
		
		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCpf.setColumns(10);
		txtCpf.setBounds(71, 127, 264, 20);
		getContentPane().add(txtCpf);
		
		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(71, 221, 264, 20);
		getContentPane().add(txtTelefone);
		
		comboBoxEspecialidade = new JComboBox();
		comboBoxEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxEspecialidade.setMaximumRowCount(5);
		comboBoxEspecialidade.setModel(new DefaultComboBoxModel(new String[] {"Cardiologista", "Clínico geral", "Dermatologista", "Endocrinologista", "Neurologista"}));
		comboBoxEspecialidade.setBounds(71, 174, 264, 20);
		getContentPane().add(comboBoxEspecialidade);
		
		
		lblCrm = new JLabel("CRM");
		lblCrm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCrm.setBounds(71, 17, 46, 14);
		getContentPane().add(lblCrm);
		
		lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(71, 64, 46, 14);
		getContentPane().add(lblNome);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setBounds(71, 111, 46, 14);
		getContentPane().add(lblCpf);
		
		lblEspecialidade = new JLabel("ESPECIALIDADE");
		lblEspecialidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEspecialidade.setBounds(71, 158, 149, 14);
		getContentPane().add(lblEspecialidade);
		
		lblTelefone = new JLabel("TELEFONE");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefone.setBounds(71, 205, 86, 14);
		getContentPane().add(lblTelefone);
		
		btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCrm.setText("");
				txtCpf.setText("");
				txtTelefone.setText("");
				txtNome.setText("");				
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpar.setBounds(68, 263, 119, 23);
		getContentPane().add(btnLimpar);
		
		btnEnviar = new JButton("ENVIAR");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String cpf = txtNome.getText();
				String telefone = txtTelefone.getText();
				String crm = txtCrm.getText();
				if(nome.equals("")||cpf.equals("")||telefone.equals("")||crm.equals(""))
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				else JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
			}
		});
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnviar.setBounds(216, 263, 119, 23);
		getContentPane().add(btnEnviar);

	}
}
