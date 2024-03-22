package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Magazzino;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Magazzino.Magazzino;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Magazzino.MagazzinoRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Magazzino.MagazzinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/magazzini")
public class MagazzinoController {

    @Autowired
    private MagazzinoService magazzinoService;

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getMagazzinoById(@PathVariable Long id) throws NotFoundException {
        Magazzino magazzino = magazzinoService.getMagazzinoById(id);
        return DefaultResponse.noMessage(magazzino, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DefaultResponse> getAllMagazzini() {
        List<Magazzino> magazzini = magazzinoService.getAllMagazzini();
        return DefaultResponse.noMessage(magazzini, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> createMagazzino(@RequestBody @Validated MagazzinoRequest request, BindingResult bindingResult) throws BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Magazzino createdMagazzino = magazzinoService.createMagazzino(request);
        return DefaultResponse.noMessage(createdMagazzino, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateMagazzino(@PathVariable Long id, @RequestBody @Validated MagazzinoRequest request, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Magazzino updatedMagazzino = magazzinoService.updateMagazzino(id, request);
        return DefaultResponse.noMessage(updatedMagazzino, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteMagazzino(@PathVariable Long id) throws NotFoundException {
        magazzinoService.deleteMagazzino(id);
        String message = "Magazzino with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }
}
