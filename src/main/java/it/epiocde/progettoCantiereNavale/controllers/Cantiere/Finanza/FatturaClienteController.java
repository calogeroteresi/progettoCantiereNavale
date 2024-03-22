package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Finanza;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza.FatturaCliente;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Finanza.FatturaClienteRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Finanza.FatturaClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fatture-clienti")
public class FatturaClienteController {

    @Autowired
    private FatturaClienteService fatturaClienteService;

    @GetMapping
    public ResponseEntity<DefaultResponse> getAllFattureClienti() {
        List<FatturaCliente> fattureClienti = fatturaClienteService.getAllFattureClienti();
        return DefaultResponse.noMessage(fattureClienti, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getFatturaClienteById(@PathVariable Long id) throws NotFoundException {
        FatturaCliente fatturaCliente = fatturaClienteService.getFatturaClienteById(id);
        return DefaultResponse.noMessage(fatturaCliente, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> createFatturaCliente(@RequestBody @Validated FatturaClienteRequest fatturaClienteRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        FatturaCliente createdFatturaCliente = fatturaClienteService.createFatturaCliente(fatturaClienteRequest);
        return DefaultResponse.noMessage(createdFatturaCliente, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteFatturaCliente(@PathVariable Long id) throws NotFoundException {
        fatturaClienteService.deleteFatturaCliente(id);
        String message = "Fattura cliente with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateFatturaCliente(@PathVariable Long id, @RequestBody @Validated FatturaClienteRequest fatturaClienteRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        FatturaCliente updatedFatturaCliente = fatturaClienteService.updateFatturaCliente(id, fatturaClienteRequest);
        return DefaultResponse.noMessage(updatedFatturaCliente, HttpStatus.OK);
    }
}
