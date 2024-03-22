package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Gestione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione.ServiceOffering;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Gestione.ServiceOfferingRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Gestione.ServiceOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-offerings")
public class ServiceOfferingController {

    @Autowired
    private ServiceOfferingService serviceOfferingService;

    @GetMapping
    public ResponseEntity<DefaultResponse> getAllServiceOfferings() {
        List<ServiceOffering> serviceOfferings = serviceOfferingService.getAllServiceOfferings();
        return DefaultResponse.noMessage(serviceOfferings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getServiceOfferingById(@PathVariable Long id) throws NotFoundException {
        ServiceOffering serviceOffering = serviceOfferingService.getServiceOfferingById(id);
        return DefaultResponse.noMessage(serviceOffering, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> createServiceOffering(@RequestBody @Validated ServiceOfferingRequest request, BindingResult bindingResult) throws BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        ServiceOffering createdServiceOffering = serviceOfferingService.createServiceOffering(request);
        return DefaultResponse.noMessage(createdServiceOffering, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateServiceOffering(@PathVariable Long id, @RequestBody @Validated ServiceOfferingRequest request, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        ServiceOffering updatedServiceOffering = serviceOfferingService.updateServiceOffering(id, request);
        return DefaultResponse.noMessage(updatedServiceOffering, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteServiceOffering(@PathVariable Long id) throws NotFoundException {
        serviceOfferingService.deleteServiceOffering(id);
        String message = "Service offering with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }
}
