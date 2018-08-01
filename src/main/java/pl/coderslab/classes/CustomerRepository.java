package pl.coderslab.classes;

import java.util.List;

public interface CustomerRepository {
	void addCustomer(Customer customer);
	void removeCustomer(Customer customer);
	List<Customer> customersList();

}
