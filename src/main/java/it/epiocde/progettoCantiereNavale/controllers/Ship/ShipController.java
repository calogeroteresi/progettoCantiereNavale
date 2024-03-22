package it.epiocde.progettoCantiereNavale.controllers.Ship;

import it.epiocde.progettoCantiereNavale.entities.Ship.Ship;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Ship.ShipRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Ship.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ships")
public class ShipController {

    @Autowired
    private ShipService shipService;

    @PostMapping
    public ResponseEntity<DefaultResponse> createShip(@RequestBody @Validated ShipRequest shipRequest, BindingResult bindingResult) throws BadRequestExceptionHandler, NotFoundException {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Ship createdShip = shipService.createShip(shipRequest);
        return DefaultResponse.noMessage(createdShip, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateShip(@PathVariable Long id, @RequestBody @Validated ShipRequest shipRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Ship updatedShip = shipService.updateShip(id, shipRequest);
        return DefaultResponse.noMessage(updatedShip, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getShipById(@PathVariable Long id) throws NotFoundException {
        Ship ship = shipService.getShipById(id);
        return DefaultResponse.noMessage(ship, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DefaultResponse> getAllShips() {
        List<Ship> ships = shipService.getAllShips();
        return DefaultResponse.noMessage(ships, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteShip(@PathVariable Long id) throws NotFoundException {
        shipService.deleteShip(id);
        String message = "Ship with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }
}
