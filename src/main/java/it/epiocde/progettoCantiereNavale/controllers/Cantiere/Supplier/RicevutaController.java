package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Supplier;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Supplier.Ricevuta;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Supplier.RicevutaRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Supplier.RicevutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ricevute")
public class RicevutaController {

    @Autowired
    private RicevutaService ricevutaService;

    @GetMapping
    public ResponseEntity<DefaultResponse> getAllRicevute() {
        List<Ricevuta> ricevute = ricevutaService.getAllRicevute();
        return DefaultResponse.noMessage(ricevute, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getRicevutaById(@PathVariable Long id) throws NotFoundException {
        Ricevuta ricevuta = ricevutaService.getRicevutaById(id);
        return DefaultResponse.noMessage(ricevuta, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> createRicevuta(@RequestBody @Validated RicevutaRequest ricevutaRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Ricevuta createdRicevuta = ricevutaService.createRicevuta(ricevutaRequest);
        return DefaultResponse.noMessage(createdRicevuta, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteRicevuta(@PathVariable Long id) throws NotFoundException {
        ricevutaService.deleteRicevuta(id);
        String message = "Ricevuta with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateRicevuta(@PathVariable Long id, @RequestBody @Validated RicevutaRequest ricevutaRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Ricevuta updatedRicevuta = ricevutaService.updateRicevuta(id, ricevutaRequest);
        return DefaultResponse.noMessage(updatedRicevuta, HttpStatus.OK);
    }
}
