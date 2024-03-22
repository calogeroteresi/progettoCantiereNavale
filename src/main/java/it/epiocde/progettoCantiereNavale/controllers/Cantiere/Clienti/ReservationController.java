package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Clienti;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti.Reservation;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Clienti.ReservationRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Clienti.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<DefaultResponse> createReservation(@RequestBody @Validated ReservationRequest reservationRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Reservation createdReservation = reservationService.createReservation(reservationRequest);
        return DefaultResponse.noMessage(createdReservation, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getReservationById(@PathVariable Long id) throws NotFoundException {
        Reservation reservation = reservationService.getReservationById(id);
        return DefaultResponse.noMessage(reservation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteReservation(@PathVariable Long id) throws NotFoundException {
        reservationService.deleteReservation(id);
        String message = "Reservation with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateReservation(@PathVariable Long id, @RequestBody @Validated ReservationRequest reservationRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Reservation updatedReservation = reservationService.updateReservation(id, reservationRequest);
        return DefaultResponse.noMessage(updatedReservation, HttpStatus.OK);
    }
}
