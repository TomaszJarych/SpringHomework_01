package pl.coderslab;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.coderslab.classes.Customer;
import pl.coderslab.classes.CustomerLogger;
import pl.coderslab.classes.MemoryCustomerRepository;

public class AppMain {
	public static void main(String[] args) throws Exception {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
			CustomerLogger logger = context.getBean("simpleCustomerLogger", CustomerLogger.class);
			Customer customer = new Customer(1, "Jan", "Nowak");
			MemoryCustomerRepository repository = 
					context.getBean("memoryCustomerRepository", MemoryCustomerRepository.class);
			repository.addCustorem(customer);
			}
		}
}
