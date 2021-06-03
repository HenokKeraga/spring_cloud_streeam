package edu.mku.geodesample.service;

import edu.mku.geodesample.model.Customer;
import edu.mku.geodesample.repository.CustomerRepository;
import org.apache.geode.cache.Region;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CustomerService {
    private final CustomerRepository repository;
    private final Region region;


    public CustomerService(CustomerRepository repository, Region region) {
        this.repository = repository;
        this.region = region;
    }

    public List<String> get(String id){
        return this.repository.findById(id).map(customer -> customer.getList()).orElse( new ArrayList<>());
    }

    public void put (String name,List<String> list){
      this.repository.save( Customer.builder().name(name).list(list).build());
    }
    public void  deleteAll(){
       Set<String> keySet= this.region.keySetOnServer();
       this.region.removeAll(keySet);
    }

}
