package dependencyInjectionExample;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        // In a real application, this would interact with a database.
        // Here we are simulating with dummy data.
        if (id == 1) {
            return new Customer(1, "John Doe", "john.doe@example.com");
        } else {
            return null;
        }
    }
}