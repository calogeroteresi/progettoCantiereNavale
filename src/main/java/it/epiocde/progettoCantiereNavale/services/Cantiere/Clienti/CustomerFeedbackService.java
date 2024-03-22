package it.epiocde.progettoCantiereNavale.services.Cantiere.Clienti;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti.CustomerFeedback;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione.ServiceOffering;
import it.epiocde.progettoCantiereNavale.entities.User.Customer;
import it.epiocde.progettoCantiereNavale.repositories.Clienti.CustomerFeedbackRepo;
import it.epiocde.progettoCantiereNavale.repositories.Gestione.ServiceOfferingRepo;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.User.CustomerRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Clienti.CustomerFeedbackRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerFeedbackService {

    @Autowired
    private CustomerFeedbackRepo customerFeedbackRepository;

    @Autowired
    private CustomerRepo customerRepository;

    @Autowired
    private ServiceOfferingRepo serviceOfferingRepository;

    public CustomerFeedback createCustomerFeedback(CustomerFeedbackRequest feedbackRequest) throws NotFoundException {
        CustomerFeedback feedback = new CustomerFeedback();
        feedback.setCommento(feedbackRequest.getCommento());
        feedback.setValutazione(feedbackRequest.getValutazione());
        feedback.setDataFeedback(new Date());

        // Trova il cliente
        Customer customer = customerRepository.findById(feedbackRequest.getCustomerId())
                .orElseThrow(() -> new NotFoundException("Customer not found with ID: " + feedbackRequest.getCustomerId()));
        feedback.setCustomer(customer);

        // Trova l'offerta di servizio
        ServiceOffering serviceOffering = serviceOfferingRepository.findById(feedbackRequest.getServiceOfferingId())
                .orElseThrow(() -> new NotFoundException("Service Offering not found with ID: " + feedbackRequest.getServiceOfferingId()));
        feedback.setServiceOffering(serviceOffering);

        return customerFeedbackRepository.save(feedback);
    }

    public CustomerFeedback getCustomerFeedbackById(Long id) throws NotFoundException {
        return customerFeedbackRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer Feedback not found with ID: " + id));
    }

    public void deleteCustomerFeedback(Long id) throws NotFoundException {
        CustomerFeedback feedback = getCustomerFeedbackById(id);
        customerFeedbackRepository.delete(feedback);
    }

    public CustomerFeedback updateCustomerFeedback(Long id, CustomerFeedbackRequest feedbackRequest) throws NotFoundException {
        CustomerFeedback feedback = getCustomerFeedbackById(id);
        feedback.setCommento(feedbackRequest.getCommento());
        feedback.setValutazione(feedbackRequest.getValutazione());

        // Trova il cliente
        Customer customer = customerRepository.findById(feedbackRequest.getCustomerId())
                .orElseThrow(() -> new NotFoundException("Customer not found with ID: " + feedbackRequest.getCustomerId()));
        feedback.setCustomer(customer);

        // Trova l'offerta di servizio
        ServiceOffering serviceOffering = serviceOfferingRepository.findById(feedbackRequest.getServiceOfferingId())
                .orElseThrow(() -> new NotFoundException("Service Offering not found with ID: " + feedbackRequest.getServiceOfferingId()));
        feedback.setServiceOffering(serviceOffering);

        return customerFeedbackRepository.save(feedback);
    }
}
