package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import model.Aluno;

public class AlunoDAO implements TblDAO{

	@Override
	public void gravarBd() {
		// TODO Auto-generated method stub
		
	}
	//Sobrecarga do metodo gravarBd, grava um aluno no banco
	public void gravarBd(Aluno a) {
		
		
		try {
			Connection con = DBUtil.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO Aluno"
					+ "(idAluno, Nome)"+
					"VALUES(?,?)");
			stmt.setInt(1,a.getNumero());
			stmt.setString(2, a.getNome());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"Cadastrado com sucesso!");
		} 
		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Numero ja existe", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
	}
	
	//Retorna uma lista carregada
	@Override
	public List<Aluno> carregar() {
		List<Aluno> lista = new ArrayList<Aluno>();
		try {
			Connection con = DBUtil.getInstance().getConnection();
			String cmd = "SELECT * FROM Aluno ";
			PreparedStatement stmt = con.prepareStatement( cmd );
		
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { 
				Aluno a = new Aluno();
				a.setNome( rs.getString("Nome") );
				a.setNumero(Integer.parseInt(rs.getString("idAluno")) );
				lista.add( a );
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	//Sobrecarga do metodo remove, remove um aluno enviado do banco
	public void remove(Aluno a) {
		try {
			Connection con = DBUtil.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement("DELETE FROM Aluno WHERE idAluno = ? ");
			stmt.setInt(1, a.getNumero());
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
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
		
}
	

