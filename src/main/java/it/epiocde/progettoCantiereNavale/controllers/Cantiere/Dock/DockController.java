package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Dock;
import org.springframework.data.domain.Pageable;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Dock.Dock;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Dock.DockRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Dock.DockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/docks")
public class DockController {

    @Autowired
    private DockService dockService;


    @GetMapping
    public ResponseEntity<DefaultResponse> getAllDocks(Pageable pageable) {
        return DefaultResponse.noMessage(dockService.getAllDocks(pageable), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getDockById(@PathVariable Long id) throws NotFoundException {
        Dock dock = dockService.getDockById(id);
        return DefaultResponse.noMessage(dock, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> createDock(@RequestBody @Validated DockRequest dockRequest, BindingResult bindingResult) throws BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Dock createdDock = dockService.createDock(dockRequest);
        return DefaultResponse.noMessage(createdDock, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteDock(@PathVariable Long id) throws NotFoundException {
        dockService.deleteDock(id);
        String message = "Dock with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateDock(@PathVariable Long id, @RequestBody @Validated DockRequest dockRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Dock updatedDock = dockService.updateDock(id, dockRequest);
        return DefaultResponse.noMessage(updatedDock, HttpStatus.OK);
    }
}
