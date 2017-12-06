package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ControleSala;
import model.Sala;

import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaSala extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnVoltar;
	private JTextField txtNumero;
	private JTextField txtEscola;
	private JButton btnRemover;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;



	/**
	 * Create the frame.
	 */
	public TelaSala() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaSala.class.getResource("/view/icon.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(210, 0, 314, 393);
		contentPane.add(scrollPane);
		
		table = new JTable();
		ControleSala cs = new ControleSala();
		cs.carregar();
		scrollPane.setViewportView(table);
		table.setModel(cs);
		JButton btnCadastrar = new JButton("Cadastrar");
		//Listener do botao cadastrar
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Sala s = new Sala();
					s.setnum(Integer.parseInt(txtNumero.getText()));
					s.setEscola(txtEscola.getText());
				cs.adicionar(s);
				cs.carregar();
				table.invalidate();
				table.revalidate();
				table.repaint();
				}
				catch(NullPointerException|NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Erro no Cadastro, verifique os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnCadastrar.setBounds(10, 261, 105, 23);
		contentPane.add(btnCadastrar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu_Principal mp= new Menu_Principal();
				mp.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 329, 105, 23);
		contentPane.add(btnVoltar);
		
		lblNewLabel = new JLabel("Numero: ");
		lblNewLabel.setBounds(10, 95, 76, 14);
		contentPane.add(lblNewLabel);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(114, 92, 86, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Escola: ");
		lblNewLabel_1.setBounds(10, 141, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		txtEscola = new JTextField();
		txtEscola.setBounds(114, 138, 86, 20);
		contentPane.add(txtEscola);
		txtEscola.setColumns(10);
		
		btnRemover = new JButton("Remover");
		//Listener do botao Remover
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Sala s = new Sala();
					s.setEscola(txtEscola.getText());
					s.setnum(Integer.parseInt(txtNumero.getText()));
				//Remove o elemento Sala
				cs.remove(s);
				cs.carregar();
				//Redesenha a tabela
				table.invalidate();
				table.revalidate();
				table.repaint();
				}
				catch(NullPointerException|NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Erro, verifique os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRemover.setBounds(10, 295, 105, 23);
		contentPane.add(btnRemover);
		//A partir da selecao da linha na tabela, popula-se os campos
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				txtNumero.setText(cs.getValueAt(table.getSelectedRow(), 1).toString());
				txtEscola.setText(cs.getValueAt(table.getSelectedRow(), 0).toString());
				

			}
		});
	}
}
