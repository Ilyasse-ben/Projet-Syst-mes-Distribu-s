package net.ilyasse.customerservice.service;

import net.ilyasse.customerservice.entity.Customer;
import net.ilyasse.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    public Customer getCustomerById(UUID idCustomer){
        return customerRepository.findById(idCustomer)
                .orElseThrow(()-> new RuntimeException("Customer not find"));

    }
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
