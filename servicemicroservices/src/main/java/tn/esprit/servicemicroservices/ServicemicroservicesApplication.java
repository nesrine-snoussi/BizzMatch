package tn.esprit.servicemicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServicemicroservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicemicroservicesApplication.class, args);
    }

}
