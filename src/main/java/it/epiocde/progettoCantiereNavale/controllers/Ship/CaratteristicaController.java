package it.epiocde.progettoCantiereNavale.controllers.Ship;

import it.epiocde.progettoCantiereNavale.entities.Ship.Caratteristica;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Ship.CaratteristicaRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Ship.CaratteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/caratteristiche-nave")
public class CaratteristicaController {

    @Autowired
    private CaratteristicaService caratteristicaService;

    @PostMapping
    public ResponseEntity<DefaultResponse> createCaratteristica(@RequestBody @Validated CaratteristicaRequest request, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Caratteristica createdCaratteristica = caratteristicaService.createCaratteristica(request);
        return DefaultResponse.noMessage(createdCaratteristica, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateCaratteristica(@PathVariable Long id, @RequestBody @Validated CaratteristicaRequest request, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Caratteristica updatedCaratteristica = caratteristicaService.updateCaratteristica(id, request);
        return DefaultResponse.noMessage(updatedCaratteristica, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteCaratteristica(@PathVariable Long id) throws NotFoundException {
        caratteristicaService.deleteCaratteristica(id);
        String message = "Caratteristica nave with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getCaratteristicaById(@PathVariable Long id) throws NotFoundException {
        Caratteristica caratteristica = caratteristicaService.getCaratteristicaById(id);
        return DefaultResponse.noMessage(caratteristica, HttpStatus.OK);
    }
}
