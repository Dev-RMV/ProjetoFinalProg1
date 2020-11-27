package view;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import controller.MedicoController;
import model.Medico;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

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
	private DefaultTableModel modelMedico;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField txtConsulta;
	private JLabel lblConsulta;
	private JLabel lblInstrucoes;
	
	public MedicoGUI() {
		setTitle("Cadastro de Médicos");
		setBounds(100, 100, 778, 512);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
		
		txtCrm = new JTextField();
		txtCrm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCrm.setBounds(10, 33, 264, 25);
		getContentPane().add(txtCrm);
		txtCrm.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setColumns(10);
		txtNome.setBounds(10, 80, 264, 25);
		getContentPane().add(txtNome);
		
		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCpf.setColumns(10);
		txtCpf.setBounds(10, 127, 264, 25);
		getContentPane().add(txtCpf);
		
		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(10, 221, 264, 25);
		getContentPane().add(txtTelefone);
		
		comboBoxEspecialidade = new JComboBox();
		comboBoxEspecialidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxEspecialidade.setMaximumRowCount(5);
		comboBoxEspecialidade.setModel(new DefaultComboBoxModel(new String[] {"Cardiologista", "Clínico geral", "Dermatologista", "Endocrinologista", "Neurologista"}));
		comboBoxEspecialidade.setBounds(10, 174, 264, 25);
		getContentPane().add(comboBoxEspecialidade);
				
		lblCrm = new JLabel("CRM");
		lblCrm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCrm.setBounds(10, 17, 46, 14);
		getContentPane().add(lblCrm);
		
		lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(10, 64, 46, 14);
		getContentPane().add(lblNome);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setBounds(10, 111, 46, 14);
		getContentPane().add(lblCpf);
		
		lblEspecialidade = new JLabel("ESPECIALIDADE");
		lblEspecialidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEspecialidade.setBounds(10, 158, 149, 14);
		getContentPane().add(lblEspecialidade);
		
		lblTelefone = new JLabel("TELEFONE");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefone.setBounds(10, 205, 86, 14);
		getContentPane().add(lblTelefone);
		
		btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar(); //Declarada no fim da classe				
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpar.setBounds(155, 263, 119, 23);
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
						adicionarDados(mControl.consultar());
					}
					catch(Exception eErroCadastro) {
						JOptionPane.showMessageDialog(getContentPane(),"Algum erro ocorreu ao cadastrar... :(");
					}
				}
			}
		});
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnviar.setBounds(10, 263, 119, 23);
		getContentPane().add(btnEnviar);
		
		modelMedico = new DefaultTableModel();
		modelMedico.addColumn("CPF");
		modelMedico.addColumn("Nome");
		modelMedico.addColumn("CRM");
		modelMedico.addColumn("Especialidade");
		modelMedico.addColumn("Telefone");
				
		table = new JTable(modelMedico);
				
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 297, 742, 162);
		getContentPane().add(scrollPane);
		
		//Instanciando e aplicando à tabela um "classificador"
		TableRowSorter<DefaultTableModel> sorter= new TableRowSorter<>(modelMedico);
		table.setRowSorter(sorter);
		//Classificador adicionado.
		
		//Campo de consulta sensivel a qualquer tecla pressionada
		//A Medida que é digitado, o texto é buscado na tabela.
		txtConsulta = new JTextField();
		txtConsulta.setToolTipText("");
		txtConsulta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtConsulta.getText().equals("")) {
					sorter.setRowFilter(null);
				}
				else {
					//IMPORTANTE(1): É case sensitive, não consegui corrigir.
					//IMPORTANTE(2): A ordenação é feita pelo 1 caractere, isso dá problema com números.
					//para corrigir (2), o número de caracteres tem q ser igual (fazer validação).
					sorter.setRowFilter(RowFilter.regexFilter((txtConsulta.getText())));
				}
			}
		});
		//Fim da implementação do listener de consulta.
		
		txtConsulta.setBounds(497, 264, 255, 25);
		getContentPane().add(txtConsulta);
		txtConsulta.setColumns(10);
		
		lblConsulta = new JLabel("CONSULTA");
		lblConsulta.setToolTipText("");
		lblConsulta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsulta.setBounds(497, 241, 250, 21);
		getContentPane().add(lblConsulta);
		
		lblInstrucoes = new JLabel("<html><b><u>IMPORTANTE:</b></u> A consulta é \"Case Sensitive\", e na tabela, a ordenação se dá pelo primeiro caractere contido no campo. Logo, números podem refletir uma ordenação errada caso não contenham o mesmo número de dígitos.</html>");
		lblInstrucoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInstrucoes.setVerticalAlignment(SwingConstants.TOP);
		lblInstrucoes.setBounds(497, 37, 255, 106);
		getContentPane().add(lblInstrucoes);
				
	}
	
	//Adiciona dados na tabela, vindos da lista, que vem do BD!
	public void adicionarDados (List <Medico> listM) {
		modelMedico.setNumRows(0);
		for (Medico m: listM) {
			Object[] medico = {m.getCpf(),m.getNome(),m.getCrm(),m.getEspecialidade(),m.getTelefone()};
			modelMedico.addRow(medico);
		}
	}

	private void limpar() {
		txtCrm.setText("");
		txtCpf.setText("");
		txtTelefone.setText("");
		txtNome.setText("");		
	}
}
