package pl.coderslab.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
@Qualifier("DBCustomerLogger")
public class DBCustomerLogger implements CustomerLogger {
	private static final String JDBC_CONNECTION = "jdbc:mysql://localhost:3306/?useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "coderslab";
	private static final String INSERT_INTO_DB = "INSERT INTO SptingHomeWork_01.DBCustomerLogger (log) VALUES(?);";
	@Override
	public void log() {

		try (Connection conn = DriverManager.getConnection(JDBC_CONNECTION, USER, PASSWORD)){
			String logEntry = LocalDateTime.now() + " : Customer operation";
			System.out.println(logEntry);
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_INTO_DB);
			preparedStatement.setString(1, logEntry);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
//#### Zadanie 5 - dodatkowe
//1. Utwórz implementację interfejsu `CustomerLogger` o nazwie `DBCustomerLogger`.
//2. Klasa ma logować zmiany na klientach do bazy danych.
//3. Dodaj sterownik bazy danych oraz utwórz ziarno zajmujące się zapisem do bazy.
//4. Utwórz bazę oraz tabelę, która będzie przechowywać logi.
//5. Wstrzyknij za pomocą właściwości prostych dane wymagane do skonfigurowania połączenia.
//6. Wstrzyknij ziarno odpowiedzialne za połączenie do nowego loggera.