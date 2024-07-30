package dependencyInjectionExample;

public class DependencyInjectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create an instance of CustomerRepository
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        
        // Inject the repository into CustomerService
        CustomerService customerService = new CustomerService(customerRepository);
        
        // Use the service to find a customer
        Customer customer = customerService.getCustomerById(1);
        
        // Display customer details
        if (customer != null) {
            System.out.println("Customer found: " + customer.getName() + ", Email: " + customer.getEmail());
        } else {
            System.out.println("Customer not found.");
        }

	}

}
