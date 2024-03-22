package it.epiocde.progettoCantiereNavale.services.Ship;

import it.epiocde.progettoCantiereNavale.entities.Ship.Motore;
import it.epiocde.progettoCantiereNavale.entities.Ship.Ship;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.Ship.ShipRepo;
import it.epiocde.progettoCantiereNavale.requests.Ship.MotoreRequest;
import it.epiocde.progettoCantiereNavale.requests.Ship.ShipRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShipService {

    @Autowired
    private ShipRepo shipRepository;

    public Ship createShip(ShipRequest request) throws NotFoundException {
        Ship ship = mapRequestToEntity(request);
        return shipRepository.save(ship);
    }

    public Ship updateShip(Long id, ShipRequest request) throws NotFoundException {
        Ship ship = getShipById(id);
        Ship updatedShip = mapRequestToEntity(request);
        BeanUtils.copyProperties(updatedShip, ship, "id");
        return shipRepository.save(ship);
    }

    private Ship mapRequestToEntity(ShipRequest request) throws NotFoundException {
        Ship ship = new Ship();
        // Mappa i campi semplici
        ship.setMarca(request.getMarca());
        ship.setModello(request.getModello());
        ship.setAnno(request.getAnno());
        ship.setStato(request.getStato());
        ship.setPrezzo(request.getPrezzo());
        ship.setTipoBarca(request.getTipoBarca());
        ship.setClasse(request.getClasse());
        ship.setLunghezzaMetri(request.getLunghezzaMetri());
        ship.setLarghezzaMetri(request.getLarghezzaMetri());
        ship.setBaglio(request.getBaglio());
        ship.setPesoSecco(request.getPesoSecco());
        ship.setTipoCarburante(request.getTipoCarburante());
        ship.setMaterialeScafo(request.getMaterialeScafo());
        ship.setBagni(request.getBagni());
        ship.setPostiLetto(request.getPostiLetto());
        ship.setPesoKg(request.getPesoKg());
        ship.setCapacitaPersone(request.getCapacitaPersone());
        ship.setPropulsione(request.getPropulsione());
        ship.setOmologazione(request.getOmologazione());

        // Mappa i campi complessi come le liste di motori, caratteristiche, ecc.
        // Esempio per la lista di motori
        List<Motore> motori = new ArrayList<>();
        for (MotoreRequest motoreRequest : request.getMotori()) {
            Motore motore = mapMotoreRequestToEntity(motoreRequest); // Implementa questo metodo
            motori.add(motore);
        }
        ship.setMotori(motori);


        return ship;
    }

    private Motore mapMotoreRequestToEntity(MotoreRequest motoreRequest) {
        Motore motore = new Motore();
        motore.setTipoMotore(motoreRequest.getTipoMotore());
        motore.setMarca(motoreRequest.getMarca());
        motore.setModello(motoreRequest.getModello());
        motore.setTipoCarburante(motoreRequest.getTipoCarburante());
        motore.setAnno(motoreRequest.getAnno());
        motore.setPotenzaHp(motoreRequest.getPotenzaHp());
        motore.setTipoTrasmissione(motoreRequest.getTipoTrasmissione());
        motore.setOreMotore(motoreRequest.getOreMotore());

        // Imposta la relazione con la nave
        Ship ship = new Ship();
        ship.setId(motoreRequest.getShipId());
        motore.setShip(ship);

        return motore;
    }


    public Ship getShipById(Long id) throws NotFoundException {
        return shipRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Nave non trovata"));
    }
}
