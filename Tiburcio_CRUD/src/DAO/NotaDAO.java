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
import model.Nota;
import model.Sala;

public class NotaDAO implements TblDAO{

	@Override
	public void gravarBd() {
		// TODO Auto-generated method stub
		
	}
	//Adiciona um objeto Nota no banco
	public void gravarBd(Nota n) {
		
		try {
			Connection con = DBUtil.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO Nota"
					+ "(Aluno_idAluno,N1, N2, Media, Sala_Materia_idMateria, Aula_Hora, Aula_Dia, Sala_idSala)"+
					"VALUES(?,?,?,?,?,?,?,?)");
			stmt.setInt(1,n.getA().getNumero());
			stmt.setFloat(2, (float) n.getN1());
			stmt.setFloat(3, (float) n.getN2());
			stmt.setFloat(4, (float) n.getMedia());
			stmt.setString(5, n.getMs().getM().getCodigo());
			stmt.setString(6, n.getMs().getHora());
			stmt.setString(7, n.getMs().getDia());
			stmt.setInt(8, n.getMs().getS().getnum());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"Cadastrado com sucesso!");
			
		} 
		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Aluno ja esta cadastrado na sala", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Erro no Sql, verifique a senha, ou o banco", "ERRO", JOptionPane.ERROR_MESSAGE);

			}
		}
	@Override
	public List<Nota> carregar() {
		return null;
		
	}
	//Retorna uma lista carregada com dados do banco
	public List<Nota> carregar(int idSala, String idMat){
		List<Nota> nota = new ArrayList<Nota>();
		try {
			
			
			Connection con = DBUtil.getInstance().getConnection();
			String cmd = "SELECT n.*, a.Nome FROM Nota AS n  "
					+ "INNER JOIN Aluno AS a ON n.Aluno_idAluno = a.idAluno WHERE n.Sala_idSala = ? AND n.Sala_Materia_idMateria = ?";
			PreparedStatement stmt = con.prepareStatement( cmd );
			stmt.setInt(1, idSala);
			stmt.setString(2, idMat);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { 
				Nota n = new Nota();
				Aluno a =  new Aluno();
				Materia m = new Materia();
				a.setNumero(Integer.parseInt(rs.getString("Aluno_idAluno")));
				a.setNome(rs.getString("Nome"));
				n.setA(a);
				m.setCodigo(rs.getString("Sala_Materia_idMateria"));
				n.setN1(Float.parseFloat(rs.getString("N1")));
				n.setN2(Float.parseFloat(rs.getString("N2")));
				n.setMedia(Float.parseFloat(rs.getString("Media")));
				nota.add(n);
				
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro no Sql, verifique a senha, ou o banco", "ERRO", JOptionPane.ERROR_MESSAGE);

		}
		return nota;
		
	}
	
	//Realiza uma ataulizaçao no banco
	public void atualizar(Nota n) {
		try {
			Connection con = DBUtil.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement("UPDATE Nota SET N1 = ?, N2 = ?, Media = ?"
			+ "WHERE Sala_Materia_idMateria = ? AND Aluno_idAluno = ?");
			stmt.setFloat(1,(float) n.getN1());
			stmt.setFloat(2, (float) n.getN2());
			stmt.setFloat(3, (float) n.getMedia());
			stmt.setString(4, n.getM().getCodigo());
			stmt.setInt(5, n.getA().getNumero());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"Atualizado com sucesso!");
		} 
		catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Numero ja existe", "ERRO", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Erro no Sql, verifique a senha, ou o banco", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
		}
	@Override
	public void remove() {
		
		
	}


	

}
