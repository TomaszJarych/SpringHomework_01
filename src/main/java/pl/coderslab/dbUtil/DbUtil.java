package pl.coderslab.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private static final String JDBC_CONNECTION = "jdbc:mysql://localhost:3306/?useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "coderslab";
	private static Connection connection;

	public static Connection getConnection() throws SQLException {
			connection = DriverManager.getConnection(JDBC_CONNECTION, USER, PASSWORD); 
		return connection;
	}
}
