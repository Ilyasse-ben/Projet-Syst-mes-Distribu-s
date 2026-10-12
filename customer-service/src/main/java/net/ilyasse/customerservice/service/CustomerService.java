package net.ilyasse.customerservice.service;

import net.ilyasse.customerservice.dto.CustomerDto;
import net.ilyasse.customerservice.entity.Customer;
import net.ilyasse.customerservice.repository.CustomerRepository;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @McpTool(description = "get all customers")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    @McpTool(description = "find customer By Id")
    public Customer getCustomerById(@McpToolParam(description = "the customer id") UUID idCustomer){
        return customerRepository.findById(idCustomer)
                .orElseThrow(()-> new RuntimeException("Customer not find"));

    }
    @McpTool(description = "save new customer")
    public Customer saveCustomer(@McpToolParam(description = "the customer to save (name, email") CustomerDto customerDto){
        Customer customer=Customer.builder().name(customerDto.getName()).email(customerDto.getEmail()).build();
        return customerRepository.save(customer);
    }
}
