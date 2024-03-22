package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Dock;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Dock.DockAvailability;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Dock.DockAvailabilityRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Dock.DockAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dock-availabilities")
public class DockAvailabilityController {

    @Autowired
    private DockAvailabilityService dockAvailabilityService;

    @PostMapping
    public ResponseEntity<DefaultResponse> createDockAvailability(@RequestBody @Validated DockAvailabilityRequest dockAvailabilityRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        DockAvailability createdDockAvailability = dockAvailabilityService.createDockAvailability(dockAvailabilityRequest);
        return DefaultResponse.noMessage(createdDockAvailability, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getDockAvailabilityById(@PathVariable Long id) throws NotFoundException {
        DockAvailability dockAvailability = dockAvailabilityService.getDockAvailabilityById(id);
        return DefaultResponse.noMessage(dockAvailability, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteDockAvailability(@PathVariable Long id) throws NotFoundException {
        dockAvailabilityService.deleteDockAvailability(id);
        String message = "Dock Availability with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateDockAvailability(@PathVariable Long id, @RequestBody @Validated DockAvailabilityRequest dockAvailabilityRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        DockAvailability updatedDockAvailability = dockAvailabilityService.updateDockAvailability(id, dockAvailabilityRequest);
        return DefaultResponse.noMessage(updatedDockAvailability, HttpStatus.OK);
    }
}
