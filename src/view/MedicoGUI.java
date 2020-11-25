package view;

import model.Medico;

import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.MedicoController;
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
		setTitle("Cadastro de Médicos");
		setBounds(100, 100, 331, 336);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
		
		txtCrm = new JTextField();
		txtCrm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCrm.setBounds(26, 33, 264, 25);
		getContentPane().add(txtCrm);
		txtCrm.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setColumns(10);
		txtNome.setBounds(26, 80, 264, 25);
		getContentPane().add(txtNome);
		
		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCpf.setColumns(10);
		txtCpf.setBounds(26, 127, 264, 25);
		getContentPane().add(txtCpf);
		
		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(26, 221, 264, 25);
		getContentPane().add(txtTelefone);
		
		comboBoxEspecialidade = new JComboBox();
		comboBoxEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxEspecialidade.setMaximumRowCount(5);
		comboBoxEspecialidade.setModel(new DefaultComboBoxModel(new String[] {"Cardiologista", "Clínico geral", "Dermatologista", "Endocrinologista", "Neurologista"}));
		comboBoxEspecialidade.setBounds(26, 174, 264, 25);
		getContentPane().add(comboBoxEspecialidade);
				
		lblCrm = new JLabel("CRM");
		lblCrm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCrm.setBounds(26, 17, 46, 14);
		getContentPane().add(lblCrm);
		
		lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(26, 64, 46, 14);
		getContentPane().add(lblNome);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setBounds(26, 111, 46, 14);
		getContentPane().add(lblCpf);
		
		lblEspecialidade = new JLabel("ESPECIALIDADE");
		lblEspecialidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEspecialidade.setBounds(26, 158, 149, 14);
		getContentPane().add(lblEspecialidade);
		
		lblTelefone = new JLabel("TELEFONE");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefone.setBounds(26, 205, 86, 14);
		getContentPane().add(lblTelefone);
		
		btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar(); //Declarada no fim da classe				
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpar.setBounds(171, 263, 119, 23);
		getContentPane().add(btnLimpar);
		
		btnEnviar = new JButton("ENVIAR");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				long cpf = -666;
				String crm = txtCrm.getText();
				long telefone = -666;
				String especialidade = (String) comboBoxEspecialidade.getSelectedItem();
				try{
					cpf = Long.parseLong(txtCpf.getText());
					telefone = Long.parseLong(txtTelefone.getText());
				}
				catch(Exception eInvalido){
					JOptionPane.showMessageDialog(getContentPane(), "Dados inválidos!"+eInvalido.getMessage());
				}
				if(nome.equals("")||cpf==-666||telefone==-666||crm.equals(""))
					JOptionPane.showMessageDialog(getContentPane(), "Preencha todos os campos");
				else {
					try{
						MedicoController mControl=new MedicoController();
						mControl.cadastrar(nome,cpf,crm,telefone,especialidade);
						JOptionPane.showMessageDialog(getContentPane(), "Cadastro feito com sucesso!");
						limpar();
					}
					catch(Exception eErroCadastro) {
						JOptionPane.showMessageDialog(getContentPane(),"Algum erro ocorreu ao cadastrar... :(");
					}
				}
			}
		});
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnviar.setBounds(26, 263, 119, 23);
		getContentPane().add(btnEnviar);
	}

	private void limpar() {
		txtCrm.setText("");
		txtCpf.setText("");
		txtTelefone.setText("");
		txtNome.setText("");		
	}
}
