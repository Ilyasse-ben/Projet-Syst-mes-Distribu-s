package net.ilyasse.customerservice.contoller;

import net.ilyasse.customerservice.entity.Customer;
import net.ilyasse.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/Customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping
    public List<Customer> getAll(){
        return customerService.getAllCustomers();
    }
    @GetMapping("/{id}")
    public Customer getCUstomer(@PathVariable UUID id){
        return customerService.getCustomerById(id);
    }
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }
}
