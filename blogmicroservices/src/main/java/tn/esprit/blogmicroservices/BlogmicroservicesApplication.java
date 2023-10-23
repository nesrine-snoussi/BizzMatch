package tn.esprit.blogmicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BlogmicroservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogmicroservicesApplication.class, args);
    }

}
