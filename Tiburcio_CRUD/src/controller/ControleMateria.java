package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import DAO.MateriaDAO;
import model.Materia;

public class ControleMateria implements TableModel{
		private List<Materia> materias  = new ArrayList<Materia>();
		private MateriaDAO md = new MateriaDAO();
			
		
		
			//Adiciona a materia no Banco
			public void adicionar(Materia a){
				md.gravarBd(a);
									
			}
			//Carrega a lista com dados do banco
			public void carregarTab() {
				materias = md.carregar();
				
			}
			//Remove materia do banco 
			public void remove(Materia m){
				md.remove(m);
				
				
			}
			//Retorna a lista de materias
			public List retornaL() {
				materias = md.carregar();
				return materias;
				
			}
			
		    public Materia getItem(int i){
				return materias.get(i);
				
			}
		    
		    //Retorna um vetor com os pesos correspondentes da materia
		    public float[] pesos(String idMateria){
		    	return md.pesos(idMateria);
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

			//Quantidade de colunas
			@Override
			public int getColumnCount() {
				// TODO Auto-generated method stub
				return 4;
			}

			//Nome das colunas
			@Override
			public String getColumnName(int coluna) {
				switch( coluna ) { 
				case 0 : return "Codigo";
				case 1 : return "Nome";
				case 2 : return "PesoN1";
				case 3 : return "PesoN2";
			}
			
				return "";
				
			}

			@Override
			public int getRowCount() {
				return materias.size();
			}

			//Retornar o valor das colunas
			@Override
			public Object getValueAt(int linha, int coluna) {
				Materia m = materias.get( linha );
				switch( coluna ) { 
					case 0 : return m.getCodigo();
					case 1 : return m.getNome();
					case 2 : return m.getPesoN1();
					case 3 : return m.getPesoN2();
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

