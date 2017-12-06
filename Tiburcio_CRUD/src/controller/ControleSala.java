package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.sun.javafx.geom.AreaOp.AddOp;

import DAO.SalaDAO;
import model.Sala;

	public class ControleSala implements TableModel{
		private List<Sala> salas  = new ArrayList<Sala>();
		SalaDAO sd = new SalaDAO();
		
		//Adiciona Sala no Banco
		public void adicionar(Sala s){			
			sd.gravaBd(s);			
		}
		
		//Carrega a lista com dados do banco
		public void carregar() {
			salas = sd.carregar();
		}
		
		//Remove dado do banco
		public void remove(Sala s) {
			sd.remove(s);
		}
		//Retorna a lista
		public List retornaL() {
			salas = sd.carregar();
			return salas;
			
		}
		
	    public Sala getItem(int i){
			return salas.get(i);
			
		}
		@Override
		public void addTableModelListener(TableModelListener arg0) {
			
		}
		
		

		@Override
		public Class<?> getColumnClass(int coluna) {
			switch( coluna ) { 
			case 0 : return String.class;
			case 1 : return String.class;
			
			
		}
		return String.class;

		}

		//Quantidade de Colunas
		@Override
		public int getColumnCount() {
			return 2;
		}

		//Nome das colunas
		@Override
		public String getColumnName(int coluna) {
			switch( coluna ) { 
			case 0 : return "Escola";
			case 1 : return "Numero";
		}
		
			return "";
			
		}

		@Override
		public int getRowCount() {
			return salas.size();
		}

		@Override
		public Object getValueAt(int linha, int coluna) {
			Sala s = salas.get( linha );
			switch( coluna ) { 
				case 0 : return s.getEscola();
				case 1 : return s.getnum();
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
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			
		}
		//Retorna o indice da sala
		 public int salaIndex(int e) {
			 
			   return salas.indexOf(e);
			 
				   
	   }
		
	}

