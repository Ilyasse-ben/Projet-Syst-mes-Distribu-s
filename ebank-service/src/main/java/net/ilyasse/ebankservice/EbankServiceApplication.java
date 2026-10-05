package net.ilyasse.ebankservice;

import net.ilyasse.ebankservice.entity.BankAccount;
import net.ilyasse.ebankservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EbankServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository){
        return args -> {
            for(int i=0; i<20;i++){
                bankAccountRepository.save(
                        BankAccount.builder().type("ok").balance(1000*Math.random()).build()
                );
            }

        };
    }

}
