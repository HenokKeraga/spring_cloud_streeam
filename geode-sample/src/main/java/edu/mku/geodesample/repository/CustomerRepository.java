package edu.mku.geodesample.repository;

import edu.mku.geodesample.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,String> {
}
