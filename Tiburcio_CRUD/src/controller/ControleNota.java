package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import DAO.NotaDAO;
import DAO.SalaDAO;
import model.Aluno;
import model.Nota;
import model.Sala;

public class ControleNota implements TableModel{
	private List<Nota> notas  = new ArrayList<Nota>();
	NotaDAO nd = new NotaDAO();
	
	//Adiciona nota no Banco
	public void adicionar(Nota n){
	   
		nd.gravarBd(n);
	  
		
		
	}
    //Calcula a Media
	public float calcMedia(Nota n, String id) {
		float media = 0.0f;
		float[] pesos = new float[2];
		if (n.getN1()<=10 && n.getN1()>=0 && n.getN2()>=0 && n.getN2()<=10) {
			ControleMateria cm = new ControleMateria();
			pesos = cm.pesos(id);
			media = (float) (((n.getN1() * pesos[0]) + (n.getN2()*pesos[1]))/10); 
			
		}
		else {
			throw new NullPointerException();
		}
			return media;
	}

	//Realiza a atualização do campo
	public void atualizar(Nota n) {
		
			nd.atualizar(n);
		   
		   
	}
	//Popula a lista com dados do banco
	public void carregar(int idSala, String idMat) {
		notas=nd.carregar(idSala, idMat);
	}
	
	//Retorna a lista de notas
	public List retornaL() {
		return notas;
		
	}
	
	
    public Nota getItem(int i){
		return notas.get(i);
		
	}
	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	public Class<?> getColumnClass(int coluna) {
		switch( coluna ) { 
		case 0 : return String.class;
		case 1 : return String.class;
		case 2 : return String.class;
		case 3 : return String.class;
		case 4 : return String.class;
	}
	return String.class;

	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}
	

	//Nome das colunas
	@Override
	public String getColumnName(int coluna) {
		switch( coluna ) { 
		case 0 : return "Numero";
		case 1 : return "Nome";
		case 2 : return "Nota1";
		case 3 : return "Nota2";
		case 4 : return "Media";
	}
	
		return "";
		
	}
	@Override
	public int getRowCount() {
		return notas.size();
	}

	//	Retorna o conteudo da coluna
	@Override
	public Object getValueAt(int linha, int coluna) {
		Nota n = notas.get( linha );
		switch( coluna ) { 
			case 0 : return n.getA().getNumero();
			case 1 : return n.getA().getNome();
			case 2 : return n.getN1();
			case 3 : return n.getN2();
			case 4 : return n.getMedia();
		}
		return "";
}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
}
