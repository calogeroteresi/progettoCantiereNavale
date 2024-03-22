package it.epiocde.progettoCantiereNavale.services;

import it.epiocde.progettoCantiereNavale.entities.User.Customer;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.User.CustomerRepo;
import it.epiocde.progettoCantiereNavale.requests.User.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepository;

    public Customer getCustomerById(Long id) throws NotFoundException {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        } else {
            throw new NotFoundException("Customer not found with ID: " + id);
        }
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer createCustomer(CustomerRequest customerRequest) {
        Customer customer = mapRequestToEntity(customerRequest);
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, CustomerRequest customerRequest) throws NotFoundException {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setIndirizzo(customerRequest.getIndirizzo());
            customer.setNumeroTelefono(customerRequest.getNumeroTelefono());
            customer.setTipoCliente(customerRequest.getTipoCliente());
            // Aggiorna altri campi se necessario
            return customerRepository.save(customer);
        } else {
            throw new NotFoundException("Customer not found with ID: " + id);
        }
    }

    public void deleteCustomer(Long id) throws NotFoundException {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            customerRepository.delete(optionalCustomer.get());
        } else {
            throw new NotFoundException("Customer not found with ID: " + id);
        }
    }

    private Customer mapRequestToEntity(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setIndirizzo(customerRequest.getIndirizzo());
        customer.setNumeroTelefono(customerRequest.getNumeroTelefono());
        customer.setTipoCliente(customerRequest.getTipoCliente());
        // Altri campi possono essere mappati qui, se necessario
        return customer;
    }
}
