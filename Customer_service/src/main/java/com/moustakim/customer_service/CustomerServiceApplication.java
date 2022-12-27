package com.moustakim.customer_service;

import com.moustakim.customer_service.entities.Customer;
import com.moustakim.customer_service.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.saveAll(List.of(
                    Customer.builder().name("Mohamed").email("mohamed@gmail.com").build(),
                    Customer.builder().name("Hassan").email("hassan@gmail.com").build(),
                    Customer.builder().name("IMane").email("imane@gmail.com").build()
            ));
            customerRepository.findAll().forEach(System.out::println);
        };
    }
}
