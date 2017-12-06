package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import DAO.AlunoDAO;
import model.Aluno;

public class ControleAluno implements TableModel{
private List<Aluno> alunos  = new ArrayList<Aluno>();
private AlunoDAO ad = new AlunoDAO();
	
	//Metodo reponsavel por adicionar Alunos no Banco
	public void adicionar(Aluno a){
		ad.gravarBd(a);
			
		
		
	}
	//Popula a lista com dados vindos do Banco
	public void carregarTab() {
		alunos = ad.carregar();
		
	}
	
	//Remove o dado do banco
	public void remove(Aluno a){
		ad.remove(a);
		
		
	}
	
    public Aluno getItem(int i){
		return alunos.get(i);
		
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
	}
	return String.class;

	}

	//Quantidade de Colunas da tabela
	@Override
	public int getColumnCount() {
		
		return 2;
	}

	//Nome das Colunas
	@Override
	public String getColumnName(int coluna) {
		switch( coluna ) { 
		case 0 : return "Numero";
		case 1 : return "Nome";
	}
	
		return "";
		
	}

	@Override
	public int getRowCount() {
		return alunos.size();
	}

	//Regatar valor das colunas
	@Override
	public Object getValueAt(int linha, int coluna) {
		Aluno a = alunos.get( linha );
		switch( coluna ) { 
			case 0 : return a.getNumero();
			case 1 : return a.getNome();
		}
		return "";
	}
	

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int linha, int coluna) {
		
		}
		
	
	
}
