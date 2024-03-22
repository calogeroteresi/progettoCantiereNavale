package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Manutenzione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Manutenzione.Maintenance;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Manutenzione.MaintenanceRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Manutenzione.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getMaintenanceById(@PathVariable Long id) throws NotFoundException {
        Maintenance maintenance = maintenanceService.getMaintenanceById(id);
        return DefaultResponse.noMessage(maintenance, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DefaultResponse> getAllMaintenances() {
        List<Maintenance> maintenances = maintenanceService.getAllMaintenances();
        return DefaultResponse.noMessage(maintenances, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> createMaintenance(@RequestBody @Validated MaintenanceRequest request, BindingResult bindingResult) throws BadRequestExceptionHandler, NotFoundException {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Maintenance createdMaintenance = maintenanceService.createMaintenance(request);
        return DefaultResponse.noMessage(createdMaintenance, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateMaintenance(@PathVariable Long id, @RequestBody @Validated MaintenanceRequest request, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Maintenance updatedMaintenance = maintenanceService.updateMaintenance(id, request);
        return DefaultResponse.noMessage(updatedMaintenance, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteMaintenance(@PathVariable Long id) throws NotFoundException {
        maintenanceService.deleteMaintenance(id);
        String message = "Maintenance with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }
}
