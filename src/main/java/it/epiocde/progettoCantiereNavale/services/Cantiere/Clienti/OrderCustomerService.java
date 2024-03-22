package it.epiocde.progettoCantiereNavale.services.Cantiere.Clienti;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti.OrderCustomer;
import it.epiocde.progettoCantiereNavale.entities.User.Customer;
import it.epiocde.progettoCantiereNavale.repositories.Clienti.OrderCustomerRepo;
import it.epiocde.progettoCantiereNavale.repositories.Gestione.ServiceOfferingRepo;
import it.epiocde.progettoCantiereNavale.repositories.User.CustomerRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Clienti.OrderCustomerRequest;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderCustomerService {
    @Autowired
    private OrderCustomerRepo orderCustomerRepository;

    @Autowired
    private CustomerRepo customerRepository;

    @Autowired
    private ServiceOfferingRepo serviceOfferingRepository;

    public Page<OrderCustomer> getAllOrders(Pageable pageable) {
        return orderCustomerRepository.findAll(pageable);
    }

    public OrderCustomer getOrderById(Long id) throws NotFoundException {
        return orderCustomerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order Customer not found with ID: " + id));
    }

    public OrderCustomer createOrder(OrderCustomerRequest orderCustomerRequest) throws NotFoundException {
        OrderCustomer orderCustomer = new OrderCustomer();
        orderCustomer.setDataOrdine(orderCustomerRequest.getDataOrdine());
        orderCustomer.setImportoTotale(orderCustomerRequest.getImportoTotale());

        Customer customer = customerRepository.findById(orderCustomerRequest.getCustomerId())
                .orElseThrow(() -> new NotFoundException("Customer not found with ID: " + orderCustomerRequest.getCustomerId()));
        orderCustomer.setCustomer(customer);

        List<Long> serviceOfferingIds = orderCustomerRequest.getServiceOfferingIds();
        if (serviceOfferingIds != null && !serviceOfferingIds.isEmpty()) {
            for (Long serviceOfferingId : serviceOfferingIds) {
                orderCustomer.getServiceOfferings().add(
                        serviceOfferingRepository.findById(serviceOfferingId)
                                .orElseThrow(() -> new NotFoundException("Service Offering not found with ID: " + serviceOfferingId))
                );
            }
        } else {
            throw new NotFoundException("At least one service offering ID is required");
        }

        return orderCustomerRepository.save(orderCustomer);
    }

    public void deleteOrder(Long id) throws NotFoundException {
        OrderCustomer orderCustomer = getOrderById(id);
        orderCustomerRepository.delete(orderCustomer);
    }

    public OrderCustomer updateOrder(Long id, OrderCustomerRequest orderCustomerRequest) throws NotFoundException {
        OrderCustomer orderCustomer = getOrderById(id);
        orderCustomer.setDataOrdine(orderCustomerRequest.getDataOrdine());
        orderCustomer.setImportoTotale(orderCustomerRequest.getImportoTotale());

        Customer customer = customerRepository.findById(orderCustomerRequest.getCustomerId())
                .orElseThrow(() -> new NotFoundException("Customer not found with ID: " + orderCustomerRequest.getCustomerId()));
        orderCustomer.setCustomer(customer);

        List<Long> serviceOfferingIds = orderCustomerRequest.getServiceOfferingIds();
        if (serviceOfferingIds != null && !serviceOfferingIds.isEmpty()) {
            orderCustomer.getServiceOfferings().clear();
            for (Long serviceOfferingId : serviceOfferingIds) {
                orderCustomer.getServiceOfferings().add(
                        serviceOfferingRepository.findById(serviceOfferingId)
                                .orElseThrow(() -> new NotFoundException("Service Offering not found with ID: " + serviceOfferingId))
                );
            }
        } else {
            throw new NotFoundException("At least one service offering ID is required");
        }

        return orderCustomerRepository.save(orderCustomer);
    }

    public OrderCustomer getOrderCustomerById(Long id) throws NotFoundException {
        Optional<OrderCustomer> optionalOrderCustomer = orderCustomerRepository.findById(id);
        if (!optionalOrderCustomer.isPresent()) {
            throw new NotFoundException("OrderCustomer not found with ID: " + id);
        }
        return optionalOrderCustomer.get();
    }
}
