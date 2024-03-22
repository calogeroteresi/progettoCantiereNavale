package it.epiocde.progettoCantiereNavale.services.Cantiere.Gestione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione.ServiceOffering;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.Gestione.ServiceOfferingRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Gestione.ServiceOfferingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceOfferingService {

    @Autowired
    private ServiceOfferingRepo serviceOfferingRepository;

    public List<ServiceOffering> getAllServiceOfferings() {
        return serviceOfferingRepository.findAll();
    }

    public ServiceOffering getServiceOfferingById(Long id) throws NotFoundException {
        return serviceOfferingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Service offering not found with ID: " + id));
    }

    public ServiceOffering createServiceOffering(ServiceOfferingRequest request) {
        ServiceOffering serviceOffering = new ServiceOffering();
        mapServiceOfferingRequestToEntity(request, serviceOffering);
        return serviceOfferingRepository.save(serviceOffering);
    }

    public ServiceOffering updateServiceOffering(Long id, ServiceOfferingRequest request) throws NotFoundException {
        ServiceOffering serviceOffering = getServiceOfferingById(id);
        mapServiceOfferingRequestToEntity(request, serviceOffering);
        return serviceOfferingRepository.save(serviceOffering);
    }

    public void deleteServiceOffering(Long id) throws NotFoundException {
        ServiceOffering serviceOffering = getServiceOfferingById(id);
        serviceOfferingRepository.delete(serviceOffering);
    }

    private void mapServiceOfferingRequestToEntity(ServiceOfferingRequest request, ServiceOffering entity) {
        entity.setServiceName(request.getServiceName());
        entity.setDescription(request.getDescription());
        entity.setPrice(request.getPrice());
        // Aggiungi altri campi qui se necessario
    }
}
