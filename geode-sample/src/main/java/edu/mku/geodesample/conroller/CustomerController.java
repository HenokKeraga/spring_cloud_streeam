package edu.mku.geodesample.conroller;

import edu.mku.geodesample.service.CustomerLoader;
import edu.mku.geodesample.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerLoader customerLoader;
    private final CustomerService customerService;

    public CustomerController(CustomerLoader customerLoader, CustomerService customerService) {
        this.customerLoader = customerLoader;
        this.customerService = customerService;
    }


    @GetMapping("/start")
    public ResponseEntity<?> startLoad(){
        this.customerLoader.load();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/get/{id}")
    private ResponseEntity<List<String>> getData(@PathVariable String id){
        return  ResponseEntity.status(HttpStatus.OK).body(customerService.get(id));
    }
}
