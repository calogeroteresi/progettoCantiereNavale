package it.epiocde.progettoCantiereNavale.controllers.Ship;

import it.epiocde.progettoCantiereNavale.entities.Ship.Motore;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Ship.MotoreRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Ship.MotoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motori")
public class MotoreController {

    @Autowired
    private MotoreService motoreService;

    @GetMapping
    public ResponseEntity<DefaultResponse> getAllMotori() {
        List<Motore> motori = motoreService.getAllMotori();
        return DefaultResponse.noMessage(motori, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getMotoreById(@PathVariable Long id) throws NotFoundException {
        Motore motore = motoreService.getMotoreById(id)
                .orElseThrow(() -> new NotFoundException("Motore non trovato con ID: " + id));
        return DefaultResponse.noMessage(motore, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> createMotore(@RequestBody @Validated MotoreRequest motoreRequest, BindingResult bindingResult) throws BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Motore createdMotore = motoreService.createMotore(motoreRequest);
        return DefaultResponse.noMessage(createdMotore, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteMotore(@PathVariable Long id) throws NotFoundException {
        motoreService.deleteMotore(id);
        String message = "Motore con ID " + id + " è stato eliminato";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }
}
