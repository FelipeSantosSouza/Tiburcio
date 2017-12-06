package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ControleAluno;
import controller.ControleNota;
import controller.ControleSala;
import model.Aluno;
import model.Materia;
import model.Materia_Sala;
import model.Nota;
import model.Sala;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaNota extends JFrame {

	//Componentes da tela
	private JPanel contentPane;
	private JTextField txtN2;
	private JTextField txtN1;
	private JLabel lblN2;
	private JLabel lblEscola;
	private JLabel lblMat;
	private JLabel lblAluno;
	private JLabel lblNumero;
	private JLabel lblNewLabel;
	private JLabel lblMedia;
	private JLabel lblSala;
	private JLabel lblNewLabel_1;
	private JButton btnCancelar;
	private JScrollPane scrollPane;
	private JButton btnSalvar;



	/**
	 * Create the frame.
	 */
	public TelaNota(int idSala, String idMat) {
		setTitle("Notas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaNota.class.getResource("/view/icon.jpg")));
		setBounds(100, 100, 538, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblN2 = new JLabel("Nota 2: ");
		lblN2.setBounds(10, 161, 46, 14);
		contentPane.add(lblN2);
		
		txtN2 = new JTextField();
		txtN2.setBounds(66, 158, 35, 20);
		contentPane.add(txtN2);
		txtN2.setColumns(10);
		
		lblEscola = new JLabel("Nota 1:");
		lblEscola.setBounds(10, 98, 46, 14);
		contentPane.add(lblEscola);
		
		txtN1 = new JTextField();
		txtN1.setBounds(66, 95, 35, 20);
		contentPane.add(txtN1);
		txtN1.setColumns(10);
		
		lblMat = new JLabel("");
		lblMat.setBounds(123, 7, 46, 14);
		lblMat.setText(idMat);
		contentPane.add(lblMat);
				
		lblAluno = new JLabel("Nome");
		lblAluno.setBounds(10, 33, 214, 14);
		contentPane.add(lblAluno);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(10, 58, 196, 14);
		contentPane.add(lblNumero);
		
		lblNewLabel = new JLabel("Media: ");
		lblNewLabel.setBounds(10, 212, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblMedia = new JLabel("");
		lblMedia.setBounds(66, 212, 46, 14);
		contentPane.add(lblMedia);
		
		lblSala = new JLabel(String.valueOf(idSala));
		lblSala.setBounds(66, 7, 54, 14);
		contentPane.add(lblSala);
		
		lblNewLabel_1 = new JLabel("Sala: ");
		lblNewLabel_1.setBounds(10, 7, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		
		btnCancelar = new JButton("Voltar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(10, 289, 89, 23);
		contentPane.add(btnCancelar);
		
		
		ControleNota cn = new ControleNota();
		JTable table = new JTable();
		table.setModel(cn);
		cn.carregar(idSala, idMat);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(220, 0, 300, 347);
		contentPane.add(scrollPane);
	    
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				lblNumero.setText(cn.getValueAt(table.getSelectedRow(),0).toString());
				lblAluno.setText(cn.getValueAt(table.getSelectedRow(), 1).toString());
				txtN1.setText(cn.getValueAt(table.getSelectedRow(),2).toString());
				txtN2.setText(cn.getValueAt(table.getSelectedRow(),3).toString());
				lblMedia.setText(cn.getValueAt(table.getSelectedRow(),4).toString());
			}
		});
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					Aluno a = new Aluno();
						a.setNome(lblAluno.getText());
						a.setNumero(Integer.parseInt(lblNumero.getText()));
					Materia m = new Materia();
						m.setCodigo(lblMat.getText());	
					Sala s = new Sala();
						s.setnum(Integer.parseInt(lblSala.getText()));
					Nota n = new Nota();
						n.setA(a);
						n.setM(m);
						n.setN1(Float.parseFloat(txtN1.getText()));
						n.setN2(Float.parseFloat(txtN2.getText()));
						n.setMedia(cn.calcMedia(n,idMat));
					//Envia o Elemento a ser atulaizado
					cn.atualizar(n);
					//Carrega os novos elementos atualizados
					cn.carregar(idSala, idMat);
					//Redesenha a tabela
					table.invalidate();
					table.revalidate();
					table.repaint();
				}
				catch(NullPointerException | NumberFormatException  e){
					e.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(117, 289, 89, 23);
		contentPane.add(btnSalvar);	
		
		
		
		
		
		
		
	}

}
