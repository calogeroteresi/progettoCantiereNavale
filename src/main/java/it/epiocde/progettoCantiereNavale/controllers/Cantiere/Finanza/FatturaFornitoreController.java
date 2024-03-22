package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Finanza;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza.FatturaFornitore;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Finanza.FatturaFornitoreRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Finanza.FatturaFornitoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fatture-fornitori")
public class FatturaFornitoreController {

    @Autowired
    private FatturaFornitoreService fatturaFornitoreService;

    @GetMapping
    public ResponseEntity<DefaultResponse> getAllFattureFornitori() {
        List<FatturaFornitore> fattureFornitori = fatturaFornitoreService.getAllFattureFornitori();
        return DefaultResponse.noMessage(fattureFornitori, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getFatturaFornitoreById(@PathVariable Long id) throws NotFoundException {
        FatturaFornitore fatturaFornitore = fatturaFornitoreService.getFatturaFornitoreById(id);
        return DefaultResponse.noMessage(fatturaFornitore, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> createFatturaFornitore(@RequestBody @Validated FatturaFornitoreRequest fatturaFornitoreRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        FatturaFornitore createdFatturaFornitore = fatturaFornitoreService.createFatturaFornitore(fatturaFornitoreRequest);
        return DefaultResponse.noMessage(createdFatturaFornitore, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteFatturaFornitore(@PathVariable Long id) throws NotFoundException {
        fatturaFornitoreService.deleteFatturaFornitore(id);
        String message = "Fattura fornitore with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateFatturaFornitore(@PathVariable Long id, @RequestBody @Validated FatturaFornitoreRequest fatturaFornitoreRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        FatturaFornitore updatedFatturaFornitore = fatturaFornitoreService.updateFatturaFornitore(id, fatturaFornitoreRequest);
        return DefaultResponse.noMessage(updatedFatturaFornitore, HttpStatus.OK);
    }
}
