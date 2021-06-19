package edu.miu.samplerestapp.cottroller;

import edu.miu.samplerestapp.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("hello1")
    public ResponseEntity<?> getCustomer1() {

        return ResponseEntity.status(HttpStatus.OK).body(Customer.builder().name("Henok").id("1").build());
    }
}
