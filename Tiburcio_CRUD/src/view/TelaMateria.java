package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ControleMateria;
import controller.ControleNota;
import model.Materia;

import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMateria extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtCod;
	private JTextField txtNomeMat;
	private JTextField txtPn1;
	private JTextField txtPn2;
	private JButton btnCadastrar;
	private JButton btnVoltar;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JLabel lblCodigoMat;
	private JScrollPane scrollPane;
	private JButton btnRemover;


	/**
	 * Create the frame.
	 */
	public TelaMateria() {
		setTitle("Materia");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaMateria.class.getResource("/view/icon.jpg")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 531, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(261, 0, 254, 396);
		contentPane.add(scrollPane);
		
		table = new JTable();
		ControleMateria cm = new ControleMateria();
		table.setModel(cm);
		cm.carregarTab();
		scrollPane.setViewportView(table);
		
		lblCodigoMat = new JLabel("Codigo da Materia: ");
		lblCodigoMat.setBounds(10, 67, 113, 14);
		contentPane.add(lblCodigoMat);
		
		txtCod = new JTextField();
		txtCod.setToolTipText("Exemplo: MAT, CIE, GEO");
		txtCod.setBounds(153, 64, 86, 20);
		contentPane.add(txtCod);
		txtCod.setColumns(3);
		
		lblNewLabel = new JLabel("Nome da Materia: ");
		lblNewLabel.setBounds(10, 98, 102, 14);
		contentPane.add(lblNewLabel);
		
		txtNomeMat = new JTextField();
		txtNomeMat.setBounds(153, 95, 86, 20);
		contentPane.add(txtNomeMat);
		txtNomeMat.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Peso N1: ");
		lblNewLabel_1.setBounds(10, 129, 102, 14);
		contentPane.add(lblNewLabel_1);
		
		txtPn1 = new JTextField();
		txtPn1.setBounds(153, 126, 86, 20);
		contentPane.add(txtPn1);
		txtPn1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Peso N2: ");
		lblNewLabel_2.setBounds(10, 158, 102, 14);
		contentPane.add(lblNewLabel_2);
		
		txtPn2 = new JTextField();
		txtPn2.setBounds(153, 155, 86, 20);
		contentPane.add(txtPn2);
		txtPn2.setColumns(10);
		
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Instacia e adiciona os elementos no objeto materia
				Materia m = new Materia();
				try {
					m.setCodigo(txtCod.getText());
					m.setNome(txtNomeMat.getText());
					m.setPesoN1(Float.parseFloat(txtPn1.getText()));
					m.setPesoN2(Float.parseFloat(txtPn2.getText()));
					//Se a soma os pesos forem diferentes de 10 não é feita a insercao
					if ((m.getPesoN1()+m.getPesoN2()!=10)) {
						JOptionPane.showMessageDialog(null, "Soma dos pesos deve ser <=10 e >=1", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
					else {
					cm.adicionar(m);
				    cm.carregarTab();
				    table.invalidate();
				    table.revalidate();
				    table.repaint();
					}
				} catch (NumberFormatException | NullPointerException e) {
					JOptionPane.showMessageDialog(null, "Erro no Cadastro", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCadastrar.setBounds(10, 282, 102, 23);
		contentPane.add(btnCadastrar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu_Principal mp= new Menu_Principal();
				mp.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 347, 102, 23);
		contentPane.add(btnVoltar);
		
		//Listener do botao Remover
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Materia m = new Materia();
				try {
				m.setCodigo(txtCod.getText());
				m.setNome(txtNomeMat.getText());
				m.setPesoN1(Float.parseFloat(txtPn1.getText()));
				m.setPesoN2(Float.parseFloat(txtPn2.getText()));
				//Envia o objeto a ser removido
				cm.remove(m);
				//Carrega os novos elementos 
			    cm.carregarTab();
			    //redesenha a tabela
			    table.invalidate();
			    table.revalidate();
			    table.repaint();
				}
				catch(NumberFormatException | NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "Erro, verifique os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRemover.setBounds(10, 313, 102, 23);
		contentPane.add(btnRemover);
		//A partir da selecao da linha na tabela, popula-se os campos
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
			txtCod.setText(cm.getValueAt(table.getSelectedRow(), 0).toString());
			txtNomeMat.setText(cm.getValueAt(table.getSelectedRow(), 1).toString());
			txtPn1.setText(cm.getValueAt(table.getSelectedRow(), 2).toString());
			txtPn2.setText(cm.getValueAt(table.getSelectedRow(), 3).toString());

			}
		});
		
	}
}
