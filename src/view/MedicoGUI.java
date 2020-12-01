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
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class MedicoGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static JTextField txtCrm;
	private static JTextField txtNome;
	private static JTextField txtCpf;
	private static JTextField txtTelefone;
	private JLabel lblCrm;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JLabel lblEspecialidade;
	private JLabel lblTelefone;
	private JButton btnLimpar;
	private JButton btnEnviar;
	private JButton btnDeletar;
	private JButton btnAlterar;
	private static JComboBox comboBoxEspecialidade;
	private static DefaultTableModel modelMedico;
	private JScrollPane scrollPane;
	private static JTable table;
	private static JTextField txtConsulta;
	private JLabel lblConsulta;
	private JLabel lblInstrucoes;
	
	public MedicoGUI() {
		setFont(UIManager.getFont("PasswordField.font"));
		setForeground(new Color(51, 255, 255));
		getContentPane().setBackground(Color.BLACK);
		setBackground(new Color(0, 51, 0));
		setTitle("Cadastro de Médicos - by Dev-RMV");
		setBounds(100, 100, 778, 512);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
		
		txtCrm = new JTextField();
		txtCrm.setBackground(Color.DARK_GRAY);
		txtCrm.setForeground(Color.WHITE);
		txtCrm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCrm.setBounds(10, 33, 264, 25);
		getContentPane().add(txtCrm);
		txtCrm.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setForeground(Color.WHITE);
		txtNome.setBackground(Color.DARK_GRAY);
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setColumns(10);
		txtNome.setBounds(10, 80, 264, 25);
		getContentPane().add(txtNome);
		
		txtCpf = new JTextField();
		txtCpf.setBackground(Color.DARK_GRAY);
		txtCpf.setForeground(Color.WHITE);
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCpf.setColumns(10);
		txtCpf.setBounds(10, 127, 264, 25);
		getContentPane().add(txtCpf);
		
		txtTelefone = new JTextField();
		txtTelefone.setForeground(Color.WHITE);
		txtTelefone.setBackground(Color.DARK_GRAY);
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(10, 221, 264, 25);
		getContentPane().add(txtTelefone);
		
		comboBoxEspecialidade = new JComboBox();
		comboBoxEspecialidade.setForeground(new Color(0, 204, 102));
		comboBoxEspecialidade.setBackground(Color.GRAY);
		comboBoxEspecialidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxEspecialidade.setMaximumRowCount(5);
		comboBoxEspecialidade.setModel(new DefaultComboBoxModel(new String[] {"Cardiologista", "Clínico geral", "Dermatologista", "Endocrinologista", "Neurologista"}));
		comboBoxEspecialidade.setBounds(10, 174, 264, 25);
		getContentPane().add(comboBoxEspecialidade);
				
		lblCrm = new JLabel("CRM");
		lblCrm.setForeground(Color.GREEN);
		lblCrm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCrm.setBounds(10, 17, 46, 14);
		getContentPane().add(lblCrm);
		
		lblNome = new JLabel("NOME");
		lblNome.setForeground(Color.GREEN);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(10, 64, 46, 14);
		getContentPane().add(lblNome);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setForeground(Color.GREEN);
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setBounds(10, 111, 46, 14);
		getContentPane().add(lblCpf);
		
		lblEspecialidade = new JLabel("ESPECIALIDADE");
		lblEspecialidade.setForeground(Color.GREEN);
		lblEspecialidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEspecialidade.setBounds(10, 158, 149, 14);
		getContentPane().add(lblEspecialidade);
		
		lblTelefone = new JLabel("TELEFONE");
		lblTelefone.setForeground(Color.GREEN);
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefone.setBounds(10, 205, 86, 14);
		getContentPane().add(lblTelefone);
		
		btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBackground(Color.DARK_GRAY);
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpar.setBounds(139, 263, 119, 23);
		getContentPane().add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicoController.limpaCadastro();
			}
		});
		
		btnAlterar = new JButton("ALTERAR");
		btnAlterar.setForeground(Color.BLUE);
		btnAlterar.setBackground(Color.DARK_GRAY);
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAlterar.setBounds(397, 263, 119, 23);
		getContentPane().add(btnAlterar);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicoController.alterar();
			}
		});
		
		btnDeletar = new JButton("DELETAR");
		btnDeletar.setBackground(Color.DARK_GRAY);
		btnDeletar.setForeground(Color.RED);
		btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeletar.setBounds(268, 263, 119, 23);
		getContentPane().add(btnDeletar);
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicoController.deletar();
			}
		});	
		
		btnEnviar = new JButton("ENVIAR");
		btnEnviar.setForeground(Color.GREEN);
		btnEnviar.setBackground(Color.DARK_GRAY);
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnviar.setBounds(10, 263, 119, 23);
		getContentPane().add(btnEnviar);
		btnEnviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(MedicoController.enviar()) {
					case 1:{
						JOptionPane.showMessageDialog(getContentPane(), "Dados inválidos!");
						break;
					}
					case 2:{
						JOptionPane.showMessageDialog(getContentPane(), "Preencha todos os campos");
						break;
					}
					case 3:{
						JOptionPane.showMessageDialog(getContentPane(),"Verifique a tabela abaixo.");
						break;
					}
					default: {
						JOptionPane.showMessageDialog(getContentPane(),"Algum erro ocorreu ao cadastrar... :(");
						break;
					}
				}
			}			
		});
		
		modelMedico = new DefaultTableModel();
		modelMedico.addColumn("CPF");
		modelMedico.addColumn("Nome");
		modelMedico.addColumn("CRM");
		modelMedico.addColumn("Especialidade");
		modelMedico.addColumn("Telefone");
				
		table = new JTable(modelMedico);
		table.setBackground(new Color(0, 51, 51));
		table.setForeground(new Color(0, 100, 0));
		table.setFillsViewportHeight(isVisible());
				
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
		txtConsulta.setForeground(Color.WHITE);
		txtConsulta.setBackground(new Color(0, 102, 102));
		txtConsulta.setBounds(545, 264, 207, 25);
		getContentPane().add(txtConsulta);
		txtConsulta.setColumns(10);
		txtConsulta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtConsulta.getText().equals("")) {
					sorter.setRowFilter(null);
				}
				else {
					//IMPORTANTE(1): É case sensitive, não consegui corrigir.
					//IMPORTANTE(2): A ordenação é feita pelo 1 caractere, isso dá problema com números.
					//para corrigir (2), o número de caracteres tem q ser igual (fazer validação).
					//IMPORTANTE(3): Os dados são consultados da TABELA (model) e não do BD!!!
					sorter.setRowFilter(RowFilter.regexFilter((txtConsulta.getText())));
				}
			}
		});
		//Fim da implementação do listener de consulta.
		
		lblConsulta = new JLabel("CONSULTA");
		lblConsulta.setForeground(Color.CYAN);
		lblConsulta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsulta.setBounds(546, 242, 128, 21);
		getContentPane().add(lblConsulta);
		
		lblInstrucoes = new JLabel("<html><b><u>IMPORTANTE:</b></u> A consulta é \"Case Sensitive\", e na tabela, a ordenação se dá pelo primeiro caractere contido no campo. Logo, números podem refletir uma ordenação errada caso não contenham o mesmo número de dígitos.</html>");
		lblInstrucoes.setForeground(Color.ORANGE);
		lblInstrucoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInstrucoes.setVerticalAlignment(SwingConstants.TOP);
		lblInstrucoes.setBounds(497, 37, 255, 106);
		getContentPane().add(lblInstrucoes);
		
		JLabel lblalteraoEExclusodigite = new JLabel("<html><b><u>ALTERAÇÃO E EXCLUSÃO:</b></u>Digite o <b>CPF</b> desejado no campo de <b><u>CONSULTA</b></u> e depois clique na opção.</html>");
		lblalteraoEExclusodigite.setForeground(Color.RED);
		lblalteraoEExclusodigite.setVerticalAlignment(SwingConstants.TOP);
		lblalteraoEExclusodigite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblalteraoEExclusodigite.setBounds(497, 157, 255, 68);
		getContentPane().add(lblalteraoEExclusodigite);
	}
	
	//Adiciona dados na tabela, vindos da lista, que vem do BD!
	public static void adicionarDados (List <Medico> listM) {
		modelMedico.setNumRows(0);
		for (Medico m: listM) {
			Object[] medico = {m.getCpf(),m.getNome(),m.getCrm(),m.getEspecialidade(),m.getTelefone()};
			modelMedico.addRow(medico);
		}
	}

	public static JTextField getTxtCrm() {
		return txtCrm;
	}

		public static JTextField getTxtNome() {
		return txtNome;
	}

	public static JTextField getTxtCpf() {
		return txtCpf;
	}

	public static JTextField getTxtTelefone() {
		return txtTelefone;
	}

	public static JTextField getTxtConsulta() {
		return txtConsulta;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public JButton getBtnEnviar() {
		return btnEnviar;
	}

	public JButton getBtnDeletar() {
		return btnDeletar;
	}

	public JButton getBtnAlterar() {
		return btnAlterar;
	}

	public static JComboBox getComboBoxEspecialidade() {
		return comboBoxEspecialidade;
	}

	public static JTable getTable() {
		return table;
	}	
}