package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Menu_Principal extends JFrame {

	//Componentes da tela
	private JPanel contentPane;
	private JButton btnMaterias;
	private JButton btnCadastrarSala;
	private JButton btnAulas;
	private JButton btnAlunos;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Create the frame.
	 */
	public Menu_Principal() {
		
		setTitle("Menu");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu_Principal.class.getResource("/view/icon.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Linester para o botao Sala
		btnCadastrarSala = new JButton("Salas");
		btnCadastrarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSala ts =  new TelaSala();
				dispose();
				ts.setVisible(true);
			}
		});
		btnCadastrarSala.setBounds(10, 129, 158, 23);
		contentPane.add(btnCadastrarSala);
		
		//Linester para o botao Materias
		btnMaterias = new JButton("Materias");
		btnMaterias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaMateria tm = new TelaMateria();
				dispose();
				tm.setVisible(true);
			}
		});
		btnMaterias.setBounds(10, 95, 158, 23);
		contentPane.add(btnMaterias);
		
		//Linester para o botao Aula
		btnAulas = new JButton("Aulas");
		btnAulas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMateria_Sala tms = new TelaMateria_Sala();
				dispose();
				tms.setVisible(true);
			}
		});
		btnAulas.setBounds(10, 163, 158, 23);
		contentPane.add(btnAulas);
		
		//Linester para o botao Alunos
		btnAlunos = new JButton("Alunos");
		btnAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAluno ta =  new TelaAluno();				
				dispose();
				ta.setVisible(true);
			}
		});
		btnAlunos.setBounds(10, 197, 158, 23);
		contentPane.add(btnAlunos);
		
		//Implementacao das lables
		lblNewLabel = new JLabel("Tiburcio");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 26));
		lblNewLabel.setBounds(317, 55, 166, 51);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("CRUD para Professores");
		lblNewLabel_1.setForeground(new Color(0, 0, 139));
		lblNewLabel_1.setBounds(348, 119, 151, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Menu_Principal.class.getResource("/view/icon.jpg")));
		lblNewLabel_2.setBounds(210, 144, 305, 245);
		contentPane.add(lblNewLabel_2);
	}
}
