package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/archivio_studenti?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	private String jdbcUsername = "admin";
	private String jdbcPassword = "admin";

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
