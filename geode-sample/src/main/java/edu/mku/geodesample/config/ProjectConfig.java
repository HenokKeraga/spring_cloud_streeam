package edu.mku.geodesample.config;

import edu.mku.geodesample.model.Customer;
import edu.mku.geodesample.repository.CustomerRepository;
import edu.mku.geodesample.service.CustomerService;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionShortcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.config.annotation.*;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@EnableGemfireRepositories(basePackageClasses = {CustomerRepository.class})
@EnableEntityDefinedRegions(basePackageClasses = {Customer.class},serverRegionShortcut = RegionShortcut.LOCAL)
@EnableClusterConfiguration
//@ClientCacheApplication(
//        name = "loader",
//        durableClientId = "loader",
//        keepAlive = true
//)
@EnablePdx
@EnableLocator
@EnableManager
@CacheServerApplication(name = "loader")
@Configuration
public class ProjectConfig {
    @Bean
    public CustomerService customerService(CustomerRepository repository, Region region){
        return new CustomerService(repository,region);
    }
}
