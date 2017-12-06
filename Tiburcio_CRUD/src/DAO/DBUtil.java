package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
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
