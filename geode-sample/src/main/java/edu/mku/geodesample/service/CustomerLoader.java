package edu.mku.geodesample.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerLoader {
    private final CustomerService customerService;

    public CustomerLoader(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void load(){
        this.customerService.put("abebe", List.of("1","2","3"));
        this.customerService.put("solomon", List.of("1","2","3"));
        this.customerService.put("sisay", List.of("1","2","3"));
        this.customerService.put("mahza", List.of("1","2","3"));
        this.customerService.put("woin", List.of("1","2","3"));
    }
}

