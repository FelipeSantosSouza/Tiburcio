package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DBUtil {

	private static DBUtil instancia;
	private Connection con;
	//Conecta no banco MySQL
	private DBUtil() { 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/tiburcio";
			//Altere o terceiro campo para sua senha root do mysql, se necessario
			con = DriverManager.getConnection(url, "root", "root");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro no Cadastro, verifique os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro no Sql, verifique a senha, ou o banco", "ERRO", JOptionPane.ERROR_MESSAGE);

		}
		
	}

	//Retorna a instancia do DBUtil
	public static DBUtil getInstance() {
		if (instancia == null) { 
			instancia = new DBUtil();
		}
		return instancia;
	}
	//Retorna uma conexão
	public Connection getConnection() { 
		return con;
	}

}
