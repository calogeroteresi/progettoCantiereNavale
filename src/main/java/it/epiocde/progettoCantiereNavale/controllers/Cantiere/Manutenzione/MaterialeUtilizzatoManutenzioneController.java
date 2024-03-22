package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Manutenzione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Manutenzione.MaterialeUtilizzatoManutenzione;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Manutenzione.MaterialeUtilizzatoManutenzioneRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Manutenzione.MaterialeUtilizzatoManutenzioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance/material")
public class MaterialeUtilizzatoManutenzioneController {

    @Autowired
    private MaterialeUtilizzatoManutenzioneService materialeUtilizzatoManutenzioneService;

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getMaterialeUtilizzatoManutenzioneById(@PathVariable Long id) throws NotFoundException {
        MaterialeUtilizzatoManutenzione materialeUtilizzatoManutenzione = materialeUtilizzatoManutenzioneService.getMaterialeUtilizzatoManutenzioneById(id);
        return DefaultResponse.noMessage(materialeUtilizzatoManutenzione, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DefaultResponse> getAllMaterialiUtilizzatiManutenzione() {
        List<MaterialeUtilizzatoManutenzione> materialiUtilizzatiManutenzione = materialeUtilizzatoManutenzioneService.getAllMaterialiUtilizzatiManutenzione();
        return DefaultResponse.noMessage(materialiUtilizzatiManutenzione, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> createMaterialeUtilizzatoManutenzione(@RequestBody @Validated MaterialeUtilizzatoManutenzioneRequest request, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        MaterialeUtilizzatoManutenzione createdMateriale = materialeUtilizzatoManutenzioneService.createMaterialeUtilizzatoManutenzione(request);
        return DefaultResponse.noMessage(createdMateriale, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateMaterialeUtilizzatoManutenzione(@PathVariable Long id, @RequestBody @Validated MaterialeUtilizzatoManutenzioneRequest request, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        MaterialeUtilizzatoManutenzione updatedMateriale = materialeUtilizzatoManutenzioneService.updateMaterialeUtilizzatoManutenzione(id, request);
        return DefaultResponse.noMessage(updatedMateriale, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteMaterialeUtilizzatoManutenzione(@PathVariable Long id) throws NotFoundException {
        materialeUtilizzatoManutenzioneService.deleteMaterialeUtilizzatoManutenzione(id);
        String message = "Materiale utilizzato in manutenzione with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }
}
