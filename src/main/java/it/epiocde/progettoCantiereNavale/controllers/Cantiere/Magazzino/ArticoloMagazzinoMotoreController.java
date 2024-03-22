package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Magazzino;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Magazzino.ArticoloMagazzinoMotore;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Magazzino.ArticoloMagazzinoMotoreRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Magazzino.ArticoloMagazzinoMotoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/magazzino-motori")
public class ArticoloMagazzinoMotoreController {

    @Autowired
    private ArticoloMagazzinoMotoreService articoloMagazzinoMotoreService;

    @GetMapping
    public ResponseEntity<DefaultResponse> getAllArticoliMagazzinoMotori() {
        List<ArticoloMagazzinoMotore> articoliMagazzinoMotori = articoloMagazzinoMotoreService.getAllArticoliMagazzinoMotori();
        return DefaultResponse.noMessage(articoliMagazzinoMotori, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getArticoloMagazzinoMotoreById(@PathVariable Long id) {
        Optional<ArticoloMagazzinoMotore> articoloMagazzinoMotore = articoloMagazzinoMotoreService.getArticoloMagazzinoMotoreById(id);
        return articoloMagazzinoMotore.map(motore -> DefaultResponse.noMessage(motore, HttpStatus.OK))
                .orElseGet(() -> DefaultResponse.noObject("Articolo di magazzino del motore non trovato con ID: " + id, HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> createArticoloMagazzinoMotore(@RequestBody @Validated ArticoloMagazzinoMotoreRequest request, BindingResult bindingResult) throws NotFoundException {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(new DefaultResponse(bindingResult.getAllErrors().toString(), HttpStatus.BAD_REQUEST));
        }
        ArticoloMagazzinoMotore createdArticoloMagazzinoMotore = articoloMagazzinoMotoreService.createArticoloMagazzinoMotore(request);
        return DefaultResponse.noMessage(createdArticoloMagazzinoMotore, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteArticoloMagazzinoMotore(@PathVariable Long id) throws NotFoundException {
        articoloMagazzinoMotoreService.deleteArticoloMagazzinoMotore(id);
        String message = "Articolo di magazzino del motore con ID " + id + " è stato eliminato";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }
}
