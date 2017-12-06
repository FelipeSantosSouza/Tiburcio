package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Aluno;
import model.Materia;
import model.Materia_Sala;
import model.Sala;

public class Materia_SalaDAO implements TblDAO {

	@Override
	
	public void gravarBd() {
		// TODO Auto-generated method stub
		
	}
	//Sobrecarga do Metodo gravarBd, grava um objeto Materia_Sala no banco
    public void gravarBd(Materia_Sala m) {
		try {
			Connection con = DBUtil.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO Materia_Sala"
					+ "(Hora, Dia, Sala_idSala, Materia_idMateria)"+
					"VALUES(?,?,?,?)");
			stmt.setString(1, m.getHora());
			stmt.setString(2, m.getDia());
			stmt.setInt(3, m.getS().getnum());
			stmt.setString(4, m.getM().getCodigo());

			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"Cadastrado com sucesso!");
		} 
		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Numero ja existe", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		 catch (SQLException e) {
				e.printStackTrace();
			}
	
		
	}

    //Retorna uma lista carregada com dados do banco
	@Override
	public List carregar() {
		List<Materia_Sala> lista = new ArrayList<Materia_Sala>();
		try {
			Connection con = DBUtil.getInstance().getConnection();
			String cmd = "SELECT * FROM Materia_Sala";
			PreparedStatement stmt = con.prepareStatement( cmd );
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { 
				Materia_Sala m = new Materia_Sala();
				Sala s = new Sala();
				Materia ma = new Materia();
				m.setHora(rs.getString("Hora") );
				m.setDia(rs.getString("Dia"));
				ma.setCodigo(rs.getString("Materia_idMateria"));
				s.setnum(rs.getInt("Sala_idSala"));
				m.setM(ma);
				m.setS(s);				
				lista.add(m);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	//Sobrecarga do metodo remove, remove um objeto Materia_Sala do banco
	public void remove(Materia_Sala m) {
	try {
		Connection con = DBUtil.getInstance().getConnection();
		PreparedStatement stmt = con.prepareStatement("DELETE FROM Materia_Sala WHERE Hora = ? AND Dia = ?");
		stmt.setString(1, m.getHora());
		stmt.setString(2, m.getDia());;
		stmt.executeUpdate();
		JOptionPane.showMessageDialog(null,"Removido com sucesso!");
	} 
	catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
		JOptionPane.showMessageDialog(null, "Numero ja existe", "ERRO", JOptionPane.ERROR_MESSAGE);
	}
	 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
