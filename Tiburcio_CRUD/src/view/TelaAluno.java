package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ControleAluno;
import controller.ControleMateria_Sala;
import controller.ControleNota;
import controller.ControleSala;
import model.Aluno;
import model.Materia;
import model.Materia_Sala;
import model.Nota;
import model.Sala;



import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SingleSelectionModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;
import java.awt.Scrollbar;
import java.awt.ScrollPane;
import javax.swing.JTree;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.UIManager;

public class TelaAluno extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtNum;
	private JTable tbl_Aula;
	private JLabel label_1;
	private JLabel label;
	private JButton btnGravar;
	private JScrollPane scrollPane_1;
	private JLabel lblSala;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblMateria;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3 ;
	private JLabel lblHora;
	private JLabel lblDia;
	private JButton btnAlunoSala;
	private JButton btnMais;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem btnVoltar;
	private JButton btnRemover;


	/**
	 * Create the frame.
	 */
	public TelaAluno() {
		setTitle("Aluno");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaAluno.class.getResource("/view/icon.jpg")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		ControleAluno ca = new ControleAluno();
		JTable table = new JTable();
		ca.carregarTab();
		//Adicionanado o modelo de Tabela ControleAluno
		table.setModel(ca);
			
			//A partir da selecao da linha na tabela, popula-se os campos
				table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent e) {
						txtNum.setText(ca.getValueAt(table.getSelectedRow(),0).toString());
						txtNome.setText((String) ca.getValueAt(table.getSelectedRow(),1));

					}
				});
				
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(246, 0, 378, 495);
		contentPane.add(scrollPane);
		
		label = new JLabel("Nome:     ");
		label.setBounds(10, 388, 72, 20);
		contentPane.add(label);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(105, 388, 72, 20);
		contentPane.add(txtNome);
		
		
		txtNum = new JTextField();
		txtNum.setColumns(10);
		txtNum.setBounds(105, 419, 72, 20);
		contentPane.add(txtNum);
		
		
		//Listener do botao gravar
		btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					try {
						
						Aluno a = new Aluno();
						a.setNome(txtNome.getText());
						a.setNumero(Integer.parseInt(txtNum.getText()));
						ca.adicionar(a);
						//Carregando os elementos atualizados do banco
						ca.carregarTab();
						//Redesenhando a tabela
						table.invalidate();
						table.revalidate();
						table.repaint();
					
						}
					
					catch (NumberFormatException | NullPointerException e) {
						JOptionPane.showMessageDialog(null, "Erro no Cadastro", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			});
		btnGravar.setForeground(Color.BLACK);
		btnGravar.setBackground(UIManager.getColor("Button.background"));
		btnGravar.setBounds(107, 464, 87, 20);
		contentPane.add(btnGravar);
		
		

		label_1 = new JLabel("Numero: ");
		label_1.setBounds(10, 417, 87, 23);
		contentPane.add(label_1);
				
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 25, 218, 216);
		contentPane.add(scrollPane_1);
		
		tbl_Aula = new JTable();
		ControleMateria_Sala cms = new ControleMateria_Sala();
		cms.carregarTab();
		tbl_Aula.setModel(cms);
		scrollPane_1.setViewportView(tbl_Aula);
		
		lblSala = new JLabel("");
		lblSala.setBounds(105, 304, 114, 14);
		contentPane.add(lblSala);
		
		lblNewLabel = new JLabel("Sala: ");
		lblNewLabel.setBounds(10, 304, 72, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Materia: ");
		lblNewLabel_1.setBounds(10, 329, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		lblMateria = new JLabel("");
		lblMateria.setBounds(105, 330, 112, 14);
		contentPane.add(lblMateria);
		
		lblNewLabel_2 = new JLabel("Hora: ");
		lblNewLabel_2.setBounds(10, 252, 87, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Dia: ");
		lblNewLabel_3.setBounds(10, 277, 97, 14);
		contentPane.add(lblNewLabel_3);
		
		lblHora = new JLabel("");
		lblHora.setBounds(105, 252, 114, 14);
		contentPane.add(lblHora);
		
		
		lblDia = new JLabel("");
		lblDia.setBounds(105, 277, 115, 14);
		contentPane.add(lblDia);
		
		//A partir da selecao da linha na tabela, popula-se os campos
		tbl_Aula.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent e) {
						lblSala.setText(cms.getValueAt(tbl_Aula.getSelectedRow(), 0).toString());
						lblMateria.setText((String) cms.getValueAt(tbl_Aula.getSelectedRow(), 1).toString());
						lblDia.setText(cms.getValueAt(tbl_Aula.getSelectedRow(), 2).toString());
						lblHora.setText(cms.getValueAt(tbl_Aula.getSelectedRow(), 3).toString());
					}
				});
		
		btnAlunoSala = new JButton("Adicionar Aluno na Sala");
		//Listener do botao Adicionar Aluno a Sala
		btnAlunoSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ControleNota cn = new ControleNota();
					//Instancia elemento Aluno
					Aluno a = new Aluno();
						a.setNumero(Integer.parseInt(txtNum.getText()));
					//Instancia Elemento Sala
					Sala s = new Sala();
						s.setnum(Integer.parseInt(lblSala.getText()));
					//Instancia Elemento Materia
					Materia m = new Materia();
						m.setCodigo(lblMateria.getText());
					//Instancia Elemento Materia_Sala	
					Materia_Sala ms = new Materia_Sala();
						ms.setDia(lblDia.getText());
						ms.setHora(lblHora.getText());
						ms.setM(m);
						ms.setS(s);	
					//Instancia Elemento Nota
					Nota n = new Nota();
						n.setN1(0.0f);
						n.setN2(0.0f);
						n.setMedia(0.0f);           
					    n.setMs(ms);
						n.setA(a);
					cn.adicionar(n);
				}
				catch (NumberFormatException | NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Erro no Cadastro, selecione uma aula e um aluno", "ERRO", JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		btnAlunoSala.setBounds(10, 354, 182, 29);
		contentPane.add(btnAlunoSala);
		
		btnMais = new JButton("...");
		//Action Listener do botao mais
		btnMais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				try {
				TelaNota tn = new TelaNota(Integer.parseInt(lblSala.getText()), lblMateria.getText());
            	tn.setVisible(true);
				}
				catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Selecione uma Aula", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
				btnMais.setIcon(null);
				btnMais.setBounds(202, 354, 41, 28);
				contentPane.add(btnMais);
				
				menuBar = new JMenuBar();
				menuBar.setBounds(0, 0, 97, 21);
				contentPane.add(menuBar);
				
				mnNewMenu = new JMenu("Mais Op\u00E7\u00F5es");
				menuBar.add(mnNewMenu);
				
				btnVoltar = new JMenuItem("Voltar");
				mnNewMenu.add(btnVoltar);
				ControleSala cs = new ControleSala();
				btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu_Principal mp= new Menu_Principal();
				mp.setVisible(true);
				dispose();
			}
		});
				
		btnRemover = new JButton("Remover");
		//Listener do botao Remover
		btnRemover.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
						Aluno a = new Aluno();
							a.setNome(txtNome.getText());
							a.setNumero(Integer.parseInt(txtNum.getText()));
						ca.remove(a);
						ca.carregarTab();
						table.invalidate();
						table.revalidate();
						table.repaint();
						}
						catch (NumberFormatException | NullPointerException e1) {
							JOptionPane.showMessageDialog(null, "Erro no Cadastro", "ERRO", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnRemover.setBackground(UIManager.getColor("Button.background"));
				btnRemover.setBounds(10, 464, 87, 20);
				contentPane.add(btnRemover);		
	}
}

