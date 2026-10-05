package net.ilyasse.customerservice;

import net.ilyasse.customerservice.entity.Customer;
import net.ilyasse.customerservice.repository.CustomerRepository;
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
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            List<String> names=List.of("Ilyasse","Oualid","Aymane");
            names.forEach(name->{
                Customer customer=Customer.builder()
                        .name(name).email(name+"@gmail.com").build();
                customerRepository.save(customer);
            });
        };
    }

}
