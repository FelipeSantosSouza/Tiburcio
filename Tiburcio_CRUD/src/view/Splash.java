package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;

public class Splash extends JFrame {

	//Componentes da tela
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JProgressBar progressBar;
	private JLabel lblImagem;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splash frame = new Splash();
					frame.setUndecorated(true);
					frame.setLocationRelativeTo(null);
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
	public Splash() {
		setRootPaneCheckingEnabled(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		lblImagem = new JLabel();
	    ImageIcon logo = new ImageIcon(getClass().getResource("icon.jpg"));
	    lblImagem.setIcon(logo);
		lblImagem.setBounds(10, 0, 294, 241);
		contentPane.add(lblImagem);
		
		//Implementacao da barra de progresso
		progressBar = new JProgressBar();
		progressBar.setBounds(10, 252, 508, 14);
		contentPane.add(progressBar);
		
		//Thread reponsavel por fazer o carregamento da barra de progresso
		new Thread() {
			
			public void run() {
				for(int i=0;i<=100;i++) {
					try {
						sleep(40);
						progressBar.setValue(i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					;
					
				}
				dispose();
				Menu_Principal mn = new Menu_Principal();
				mn.setVisible(true);
			}
			
		}.start();
				
	}
}
