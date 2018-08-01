package pl.coderslab.classes;

import java.util.List;

public interface CustomerRepository {
	void addCustorem(Customer customer);
	void removeCustomer(Customer customer);
	List<Customer> customersList();

}
