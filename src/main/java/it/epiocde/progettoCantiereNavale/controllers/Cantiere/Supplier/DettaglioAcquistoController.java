package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Supplier;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Supplier.DettaglioAcquisto;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Supplier.DettaglioAcquistoRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Supplier.DettaglioAcquistoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier/purchase/detail")
public class DettaglioAcquistoController {

    @Autowired
    private DettaglioAcquistoService dettaglioAcquistoService;

    @PostMapping
    public ResponseEntity<DefaultResponse> createDettaglioAcquisto(@RequestBody @Validated DettaglioAcquistoRequest request, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        DettaglioAcquisto dettaglioAcquisto = dettaglioAcquistoService.createDettaglioAcquisto(request);
        return DefaultResponse.noMessage(dettaglioAcquisto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getDettaglioAcquistoById(@PathVariable Long id) throws NotFoundException {
        DettaglioAcquisto dettaglioAcquisto = dettaglioAcquistoService.getDettaglioAcquistoById(id);
        return DefaultResponse.noMessage(dettaglioAcquisto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateDettaglioAcquisto(@PathVariable Long id, @RequestBody @Validated DettaglioAcquistoRequest request, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        DettaglioAcquisto updatedDettaglioAcquisto = dettaglioAcquistoService.updateDettaglioAcquisto(id, request);
        return DefaultResponse.noMessage(updatedDettaglioAcquisto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteDettaglioAcquisto(@PathVariable Long id) throws NotFoundException {
        dettaglioAcquistoService.deleteDettaglioAcquisto(id);
        String message = "Dettaglio acquisto with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }
}
