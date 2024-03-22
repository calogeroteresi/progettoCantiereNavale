package it.epiocde.progettoCantiereNavale.services.Cantiere.Finanza;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza.FatturaCliente;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.Finanza.FatturaClienteRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Finanza.FatturaClienteRequest;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Clienti.OrderCustomerService;
import it.epiocde.progettoCantiereNavale.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FatturaClienteService {
    @Autowired
    private FatturaClienteRepo fatturaClienteRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderCustomerService orderCustomerService;

    public FatturaCliente getFatturaClienteById(Long id) throws NotFoundException {
        Optional<FatturaCliente> optionalFatturaCliente = fatturaClienteRepository.findById(id);
        if (!optionalFatturaCliente.isPresent()) {
            throw new NotFoundException("Fattura cliente not found with ID: " + id);
        }
        return optionalFatturaCliente.get();
    }

    public List<FatturaCliente> getAllFattureClienti() {
        return fatturaClienteRepository.findAll();
    }


    public FatturaCliente createFatturaCliente(FatturaClienteRequest fatturaClienteRequest) throws NotFoundException {
        FatturaCliente fatturaCliente = new FatturaCliente();
        mapFatturaClienteRequestToEntity(fatturaClienteRequest, fatturaCliente);
        return fatturaClienteRepository.save(fatturaCliente);
    }

    public FatturaCliente updateFatturaCliente(Long id, FatturaClienteRequest fatturaClienteRequest) throws NotFoundException {
        Optional<FatturaCliente> optionalFatturaCliente = fatturaClienteRepository.findById(id);
        if (!optionalFatturaCliente.isPresent()) {
            throw new NotFoundException("Fattura cliente not found with ID: " + id);
        }
        FatturaCliente fatturaCliente = optionalFatturaCliente.get();
        mapFatturaClienteRequestToEntity(fatturaClienteRequest, fatturaCliente);
        return fatturaClienteRepository.save(fatturaCliente);
    }

    public void deleteFatturaCliente(Long id) throws NotFoundException {
        Optional<FatturaCliente> optionalFatturaCliente = fatturaClienteRepository.findById(id);
        if (!optionalFatturaCliente.isPresent()) {
            throw new NotFoundException("Fattura cliente not found with ID: " + id);
        }
        fatturaClienteRepository.deleteById(id);
    }

    private void mapFatturaClienteRequestToEntity(FatturaClienteRequest request, FatturaCliente entity) throws NotFoundException {
        entity.setNumeroFattura(request.getNumeroFattura());
        entity.setDataEmissione(request.getDataEmissione());
        entity.setImportoTotale(request.getImportoTotale());
        entity.setStato(request.getStato());

        entity.setCustomer(customerService.getCustomerById(request.getCustomerId()));
        entity.setOrderCustomer(orderCustomerService.getOrderCustomerById(request.getOrderId()));
    }
}
