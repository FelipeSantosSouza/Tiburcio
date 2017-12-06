package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;

import controller.ControleMateria;
import controller.ControleMateria_Sala;
import controller.ControleSala;
import model.Materia;
import model.Materia_Sala;
import model.Sala;

import java.awt.Toolkit;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMateria_Sala extends JFrame {

	//Componentes da tela
	private JPanel contentPane;
	private JTable table;
    private MaskFormatter mask;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JComboBox cmbDia;
    private JLabel lblSala;
    private JComboBox cmbSala;
    private JLabel lblMateria;
    private JComboBox cmbMateria;
    private JScrollPane scrollPane;
    private JButton btnCadastrar;
    private JButton btnVoltar ;
    private JButton btnRemover;
	

	/**
	 * Create the frame.
	 */
	public TelaMateria_Sala() {
		setTitle("Aulas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaMateria_Sala.class.getResource("/view/icon.jpg")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 540, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
			
		try {	
		//Implementacao do campo de texto formatado, este pode gerar uma ParseException, por isso usa-se o try-catch
		mask = new MaskFormatter("##:##");
		JFormattedTextField txtHora = new JFormattedTextField(mask);
		txtHora.setBounds(109, 113, 34, 20);
		contentPane.add(txtHora);
					

		
		lblNewLabel = new JLabel("Hora Inicio: ");
		lblNewLabel.setBounds(10, 116, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dia: ");
		lblNewLabel_1.setBounds(10, 155, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		cmbDia = new JComboBox();
		//Popula-se o combobox com valores da EnumSamana
		cmbDia.setModel(new DefaultComboBoxModel(EnumSemana.values()));
		cmbDia.setBounds(109, 152, 104, 20);
		contentPane.add(cmbDia);
		
		lblSala = new JLabel("Sala: ");
		lblSala.setBounds(10, 87, 89, 14);
		contentPane.add(lblSala);
		
		cmbSala = new JComboBox();
		ControleSala cs = new ControleSala();
		cmbSala.setBounds(109, 84, 104, 20);
		//Popula-se o combobox com a lista carregada do banco
		cmbSala.setModel(new DefaultComboBoxModel (cs.retornaL().toArray()));
		contentPane.add(cmbSala);
		
		lblMateria = new JLabel("Materia: ");
		lblMateria.setBounds(10, 51, 89, 14);
		contentPane.add(lblMateria);
		
		cmbMateria = new JComboBox();
		ControleMateria cm = new ControleMateria();
		cmbMateria.setBounds(109, 48, 104, 20);
		//Popula-se o combobox com a lista carregada do banco
		cmbMateria.setModel(new DefaultComboBoxModel (cm.retornaL().toArray()));

		contentPane.add(cmbMateria);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(238, 0, 286, 411);
		contentPane.add(scrollPane);
		
		table = new JTable();
		ControleMateria_Sala cms = new ControleMateria_Sala();
	
		table.setModel(cms);
		cms.carregarTab();
		//A partir da selecao da linha na tabela, popula-se os campos
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent e) {
						
						cmbDia.setSelectedIndex(cms.diaIndex((String) cms.getValueAt(table.getSelectedRow(), 2)));
                        txtHora.setValue((String) cms.getValueAt(table.getSelectedRow(), 3));
						

					}
				});
		scrollPane.setViewportView(table);
		
		
		//Listener do botao cadastrar
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				//Instancias necessarias para a insercao de dados do objeto 
				Materia m = new Materia();
					m.setCodigo(cmbMateria.getSelectedItem().toString());
				Sala s = new Sala();
					s.setnum(Integer.parseInt(cmbSala.getSelectedItem().toString()));
				Materia_Sala ms = new Materia_Sala();
					ms.setDia(cmbDia.getSelectedItem().toString());
					ms.setHora(txtHora.getText());
					ms.setM(m);
					ms.setS(s);
				//Adiciona o elemento no banco
				cms.adicionar(ms);
				//Carrega os novos elementos
				cms.carregarTab();
				//Redesenha a tabela
		        table.invalidate();
		        table.revalidate();
		        table.repaint();
				}
				catch(NullPointerException|NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Erro no Cadastro", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCadastrar.setBounds(10, 292, 104, 23);
		contentPane.add(btnCadastrar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu_Principal mp= new Menu_Principal();
				mp.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 360, 104, 23);
		contentPane.add(btnVoltar);
		
		//Listener do botar Remover
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				//Instancia o elemento
				Materia_Sala ms= new Materia_Sala();
					ms.setDia(cmbDia.getSelectedItem().toString());
					ms.setHora(txtHora.getText());
				//Tenta conver para int caso nao consiga retorna uma nullpointerexception
				int h = Integer.parseInt(txtHora.getText().substring(0, 2));
				int m = Integer.parseInt(txtHora.getText().substring(3, 4));
				//Envia o objeto instanciado a ser deletado
				cms.remove(ms);
				cms.carregarTab();
				//Redesenha a tabela
				table.invalidate();
				table.revalidate();
				table.repaint();
				}
				catch(NullPointerException|NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Erro no Cadastro", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRemover.setBounds(10, 326, 104, 23);
		contentPane.add(btnRemover);
		
		} catch (ParseException e) {
				e.printStackTrace();
		}
	}
}

	