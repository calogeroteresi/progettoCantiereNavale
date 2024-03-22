package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Magazzino;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Magazzino.ArticoloMagazzino;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Magazzino.ArticoloMagazzinoRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Magazzino.ArticoloMagazzinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articoli-magazzino")
public class ArticoloMagazzinoController {

    @Autowired
    private ArticoloMagazzinoService articoloMagazzinoService;

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getArticoloMagazzinoById(@PathVariable Long id) throws NotFoundException {
        ArticoloMagazzino articoloMagazzino = articoloMagazzinoService.getArticoloMagazzinoById(id);
        return DefaultResponse.noMessage(articoloMagazzino, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DefaultResponse> getAllArticoliMagazzino() {
        List<ArticoloMagazzino> articoliMagazzino = articoloMagazzinoService.getAllArticoliMagazzino();
        return DefaultResponse.noMessage(articoliMagazzino, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> createArticoloMagazzino(@RequestBody @Validated ArticoloMagazzinoRequest request, BindingResult bindingResult) throws BadRequestExceptionHandler, NotFoundException {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        ArticoloMagazzino createdArticoloMagazzino = articoloMagazzinoService.createArticoloMagazzino(request);
        return DefaultResponse.noMessage(createdArticoloMagazzino, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateArticoloMagazzino(@PathVariable Long id, @RequestBody @Validated ArticoloMagazzinoRequest request, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        ArticoloMagazzino updatedArticoloMagazzino = articoloMagazzinoService.updateArticoloMagazzino(id, request);
        return DefaultResponse.noMessage(updatedArticoloMagazzino, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteArticoloMagazzino(@PathVariable Long id) throws NotFoundException {
        articoloMagazzinoService.deleteArticoloMagazzino(id);
        String message = "Articolo di magazzino with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }
}
