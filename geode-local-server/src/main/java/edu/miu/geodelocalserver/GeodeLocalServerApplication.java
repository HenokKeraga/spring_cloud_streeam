package edu.miu.geodelocalserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.config.annotation.CacheServerApplication;
import org.springframework.data.gemfire.config.annotation.EnableLocator;
import org.springframework.data.gemfire.config.annotation.EnableManager;

@EnableManager
@EnableLocator
@CacheServerApplication(name = "loader")
@SpringBootApplication
public class GeodeLocalServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeodeLocalServerApplication.class, args);
    }

}
