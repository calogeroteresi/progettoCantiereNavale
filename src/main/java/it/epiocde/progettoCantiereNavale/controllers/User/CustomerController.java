package it.epiocde.progettoCantiereNavale.controllers.User;

import it.epiocde.progettoCantiereNavale.entities.User.Customer;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.User.CustomerRequest;
import it.epiocde.progettoCantiereNavale.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        try {
            Customer customer = customerService.getCustomerById(id);
            return ResponseEntity.ok(customer);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerRequest customerRequest) {
        Customer createdCustomer = customerService.createCustomer(customerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody CustomerRequest customerRequest) {
        try {
            Customer updatedCustomer = customerService.updateCustomer(id, customerRequest);
            return ResponseEntity.ok(updatedCustomer);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        try {
            customerService.deleteCustomer(id);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
