package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Sala;

public class SalaDAO  implements TblDAO{

	
	
	//Sobrecarga do metodo gravarBd, grava um objeto Sala no banco
	public void gravaBd(Sala s){
		
		try {
			Connection con = DBUtil.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO Sala"
					+ "(idSala, Escola)"+
					"VALUES(?,?)");
			stmt.setInt(1,s.getnum());
			stmt.setString(2, s.getEscola());
			stmt.executeUpdate();
		} 
		
		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Numero ja existe", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Erro no Sql, verifique a senha, ou o banco", "ERRO", JOptionPane.ERROR_MESSAGE);

		}
		
	}
	//Retorna uma lista carregada com dados do banco
	public List<Sala> carregar() {
		List<Sala> lista = new ArrayList<Sala>();
		try {
			Connection con = DBUtil.getInstance().getConnection();
			String cmd = "SELECT * FROM Sala";
			PreparedStatement stmt = con.prepareStatement( cmd );
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { 
				Sala s = new Sala();
				s.setEscola( rs.getString("Escola") );
				s.setnum(Integer.parseInt(rs.getString("idSala")) );
				lista.add(s);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
		
		
	
	}
	@Override
	public void gravarBd() {
		
		
	}

	

	@Override
	public void remove() {
		
		
	}
	//Sobrecarga do metodo remove, remove um objeto Sala do banco
	public void remove(Sala s) {
		try {
			Connection con = DBUtil.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement("DELETE FROM Sala WHERE idSala = ? ");
			stmt.setInt(1, s.getnum());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"Removido com sucesso!");
		} 
		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Numero ja existe", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		 catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro, Verifique a conexão do Sql", "ERRO", JOptionPane.ERROR_MESSAGE);
			}

		}
		
	}

