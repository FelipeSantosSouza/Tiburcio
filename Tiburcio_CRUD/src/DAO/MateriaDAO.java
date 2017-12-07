package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Materia;
import model.Sala;

public class MateriaDAO implements TblDAO {

	@Override
	public void gravarBd() {
		// TODO Auto-generated method stub
		
	}
	//Grava um objeto Materia no Banco
	public void gravarBd(Materia m) {
		try {
			Connection con = DBUtil.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO Materia"
					+ "(idMateria, Nome, PesoN1, PesoN2)"+
					"VALUES(?,?,?,?)");
			stmt.setString(1, m.getCodigo());
			stmt.setString(2, m.getNome());
			stmt.setFloat(3, (float) m.getPesoN1());
			stmt.setFloat(4, (float) m.getPesoN2());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"Cadastrado com sucesso!");
		} 
		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Aluno ja esta cadastrado na sala", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		catch(com.mysql.jdbc.MysqlDataTruncation e) {
			JOptionPane.showMessageDialog(null, "Código deve conter até 3 letras", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro no Sql, verifique a senha, ou o banco", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	//Retorna uma lista carregada com dados do banco
	@Override
	public List carregar() {
		List<Materia> lista = new ArrayList<Materia>();
		try {
			Connection con = DBUtil.getInstance().getConnection();
			String cmd = "SELECT * FROM Materia";
			PreparedStatement stmt = con.prepareStatement( cmd );
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { 
				Materia m = new Materia();
				m.setCodigo( rs.getString("idMateria") );
				m.setNome(rs.getString("Nome"));
				m.setPesoN1(rs.getFloat("PesoN1"));
				m.setPesoN2(rs.getFloat("PesoN2"));				
				lista.add(m);
			}
		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro no Sql, verifique a senha, ou o banco", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		return lista;
		
	}

	//Seleciona e retorna um vetor com pesos das materias do banco
	public float[] pesos(String idMateria) {
		float[] pesos = new float[2];
		try {
			Connection con = DBUtil.getInstance().getConnection();
			String cmd = "SELECT PesoN1, PesoN2 FROM Materia WHERE idMateria = ?";
			PreparedStatement stmt = con.prepareStatement( cmd );
			stmt.setString(1, idMateria);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { 
				Materia m = new Materia();
				pesos[0]=( rs.getFloat("PesoN1"));
				pesos[1]=(rs.getFloat("PesoN2"));			
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro no Sql, verifique a senha, ou o banco", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		return pesos;
		
	}
	
	
	

	//Sobrecarga do metodo remove, remove um objeto materia do banco
	public void remove(Materia m) {
		try {
			Connection con = DBUtil.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement("DELETE FROM Materia WHERE idMateria = ?");
			stmt.setString(1, m.getCodigo());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"Removido com sucesso!");
		} 
		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Numero ja existe", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro no Sql, verifique a senha, ou o banco", "ERRO", JOptionPane.ERROR_MESSAGE);
		}

		}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
		
	}

	

