package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class MedicoGUI extends JFrame {
	private JTextField textFieldCrm;
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private JTextField textFieldTelefone;
	private JLabel lblCrm;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JLabel lblEspecialidade;
	private JLabel lblTelefone;
	private JButton btnLimpar;
	private JButton btnEnviar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicoGUI frame = new MedicoGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MedicoGUI() {
		setBounds(100, 100, 418, 336);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		textFieldCrm = new JTextField();
		textFieldCrm.setBounds(71, 33, 264, 20);
		getContentPane().add(textFieldCrm);
		textFieldCrm.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(71, 80, 264, 20);
		getContentPane().add(textFieldNome);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(71, 127, 264, 20);
		getContentPane().add(textFieldCpf);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(71, 221, 264, 20);
		getContentPane().add(textFieldTelefone);
		
		JComboBox comboBoxEspecialidade = new JComboBox();
		comboBoxEspecialidade.setMaximumRowCount(5);
		comboBoxEspecialidade.setModel(new DefaultComboBoxModel(new String[] {"Cardiologista", "Clínico geral", "Dermatologista", "Endocrinologista", "Neurologista"}));
		comboBoxEspecialidade.setBounds(71, 174, 264, 20);
		getContentPane().add(comboBoxEspecialidade);
		
		
		lblCrm = new JLabel("CRM");
		lblCrm.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCrm.setBounds(71, 17, 46, 14);
		getContentPane().add(lblCrm);
		
		lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(71, 64, 46, 14);
		getContentPane().add(lblNome);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setBounds(71, 111, 46, 14);
		getContentPane().add(lblCpf);
		
		lblEspecialidade = new JLabel("ESPECIALIDADE");
		lblEspecialidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEspecialidade.setBounds(71, 158, 149, 14);
		getContentPane().add(lblEspecialidade);
		
		lblTelefone = new JLabel("TELEFONE");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefone.setBounds(71, 205, 86, 14);
		getContentPane().add(lblTelefone);
		
		btnLimpar = new JButton("LIMPAR");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpar.setBounds(68, 263, 119, 23);
		getContentPane().add(btnLimpar);
		
		btnEnviar = new JButton("ENVIAR");
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEnviar.setBounds(216, 263, 119, 23);
		getContentPane().add(btnEnviar);

	}
}
