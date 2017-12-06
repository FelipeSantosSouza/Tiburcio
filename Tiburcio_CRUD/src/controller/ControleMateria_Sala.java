package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import DAO.Materia_SalaDAO;

import model.Materia_Sala;
import model.Sala;

public class ControleMateria_Sala implements TableModel{

	private List<Materia_Sala> materia_salas  = new ArrayList<Materia_Sala>();
	private Materia_SalaDAO ad = new Materia_SalaDAO();
		
	//Adiciona no banco se o horário estiver de acordo
		public void adicionar(Materia_Sala a){
			int h = Integer.parseInt(a.getHora().substring(0, 2));
			int m = Integer.parseInt(a.getHora().substring(3, 5));
			if((h>24) || (h<0) || (m>59) || (m<0)) {
				JOptionPane.showMessageDialog(null, "Erro no campo hora", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			else {
			ad.gravarBd(a);
			}	
			
			
		}
		//Carregar a lista com dados do banco
		public void carregarTab() {
			materia_salas = ad.carregar();
			
		}
		
		//Remove o dado do banco 
		public void remove(Materia_Sala m){
			ad.remove(m);
			
			
		}
		
		
	    public Materia_Sala getItem(int i){
			return materia_salas.get(i);
			
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
			
		}
		return String.class;

		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 4;
		}

		@Override
		public String getColumnName(int coluna) {
			switch( coluna ) { 
			case 0 : return "Sala";
			case 1 : return "Materia";
			case 2 : return "Dia";
			case 3 : return "Hora";
		}
		
			return "";
			
		}

		@Override
		public int getRowCount() {
			return materia_salas.size();
		}

		@Override
		public Object getValueAt(int linha, int coluna) {
			Materia_Sala m = materia_salas.get( linha );
			switch( coluna ) { 
				case 0 : return m.getS().getnum();
				case 1 : return m.getM().getCodigo();
				case 2 : return m.getDia();
				case 3 : return m.getHora();
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
		
		//Converte o dia da semana para um indice	
		public int diaIndex(String dia) {
			
			switch (dia) {
			case "Segunda_Feira":
				return 0;
		
			case "Terca_Feira":
				return 1;
		
			case "Quarta_Feira":
				return 2;
		
			case "Quinta_Feira":
				return 3;
		
			case "Sexta_Feira":
				return 4;
		
			case "Sabado":
				return 5;
				
		    case "Domingo":
		    	return 6;
		    }
			return 0;
	  	}
	
		//Retorna o indice da lista correspondente ao codigo enviado
	   public int matIndex(String e) {
		 
		   return materia_salas.indexOf(e);
		 
			   
	   }
	   
	}
		
	

