package dao;

import java.sql.SQLException;
import java.sql.DriverManager;
import com.mysql.jdbc.Connection;

public class DataSource {

	
		static {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}

	

	// Obtém conexão com o banco de dados
	public Connection obtemConexao() throws SQLException {
		return (Connection) DriverManager
				.getConnection("jdbc:mysql://localhost/projeto?user=root&password=admin");
	}
}
