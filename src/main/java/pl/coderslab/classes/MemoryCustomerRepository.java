package pl.coderslab.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class MemoryCustomerRepository implements CustomerRepository {
	private List<Customer> list;
	CustomerLogger customerLogger;
	@Autowired
	public MemoryCustomerRepository(@Qualifier("DBCustomerLogger")CustomerLogger customerLogger) {
		this.customerLogger = customerLogger;
		this.list = new ArrayList<>();
	}

	public void setList(List<Customer> list) {
		this.list = list;
	}

	@Override
	public void addCustomer(Customer customer) {
		this.customerLogger.log();
		this.list.add(customer);
		
	}

	@Override
	public void removeCustomer(Customer customer) {
		this.customerLogger.log();
		list.remove(customer);
	}

	@Override
	public List<Customer> customersList() {
		this.customerLogger.log();
		return list;
	}

}
