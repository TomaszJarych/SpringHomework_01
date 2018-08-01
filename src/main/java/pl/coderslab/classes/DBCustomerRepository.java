package pl.coderslab.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pl.coderslab.dbUtil.DbUtil;

@Component
public class DBCustomerRepository implements CustomerRepository {
	private static final String INSERT_CUSTOMER_INTO_DB = "INSERT INTO SptingHomeWork_01.DBCustomerRepository (customerId,firstName,lastName)VALUES(?,?,?)";
	private static final String DELETE_CUSTOMER_FROM_DB = "DELETE FROM SptingHomeWork_01.DBCustomerRepository where customerId = ?;";
	private static final String ALL_CUSTOMERS_FROM_DB = "SELECT * FROM SptingHomeWork_01.DBCustomerRepository";
	CustomerLogger customerLogger;

	@Autowired
	public DBCustomerRepository(@Qualifier("DBCustomerLogger") CustomerLogger customerLogger) {
		this.customerLogger = customerLogger;
	}

	@Override
	public void addCustomer(Customer customer) {
		try (Connection conn = DbUtil.getConnection()) {
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_CUSTOMER_INTO_DB);
			preparedStatement.setInt(1, customer.getId());
			preparedStatement.setString(2, customer.getFirstName());
			preparedStatement.setString(3, customer.getLastName());
			preparedStatement.execute();
			customerLogger.log();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeCustomer(Customer customer) {
		try (Connection conn = DbUtil.getConnection()) {
			PreparedStatement preparedStatement = conn.prepareStatement(DELETE_CUSTOMER_FROM_DB);
			preparedStatement.setInt(1, customer.getId());
			preparedStatement.execute();
			customerLogger.log();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> customersList() {
		try (Connection conn = DbUtil.getConnection()){
			List<Customer> tempList = new ArrayList<>();
			PreparedStatement preparedStatement = conn.prepareStatement(ALL_CUSTOMERS_FROM_DB);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(2);
				String firstName = resultSet.getString(3);
				String lastName = resultSet.getString(4);
				Customer customer = new Customer(id, firstName, lastName);
				tempList.add(customer);
			}
			
			return tempList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
