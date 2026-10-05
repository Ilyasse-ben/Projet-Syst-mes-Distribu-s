package net.ilyasse.ebankservice.feign;

import net.ilyasse.ebankservice.model.Customers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/api/Customers/{id}")
    Customers getCustomerById(@PathVariable UUID id);
}
