package it.epiocde.progettoCantiereNavale.services.Ship;

import it.epiocde.progettoCantiereNavale.entities.Ship.Motore;
import it.epiocde.progettoCantiereNavale.repositories.Ship.MotoreRepo;
import it.epiocde.progettoCantiereNavale.requests.Ship.MotoreRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotoreService {

    private final MotoreRepo motoreRepository;

    @Autowired
    public MotoreService(MotoreRepo motoreRepository) {
        this.motoreRepository = motoreRepository;
    }

    public List<Motore> getAllMotori() {
        return motoreRepository.findAll();
    }

    public Optional<Motore> getMotoreById(Long id) {
        return motoreRepository.findById(id);
    }

    public Motore createMotore(@NotNull @Valid MotoreRequest motoreRequest) {
        Motore motore = mapRequestToEntity(motoreRequest);
        return motoreRepository.save(motore);
    }

    public void deleteMotore(Long id) {
        motoreRepository.deleteById(id);
    }

    private Motore mapRequestToEntity(MotoreRequest motoreRequest) {
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
        // Assicurati di gestire questa parte in base alla tua logica di business
        // Ad esempio, potresti dover cercare la nave nel repository prima di impostarla nel motore
        // In questo esempio, si presume che l'ID della nave sia già presente nella richiesta del motore
        // Quindi viene semplicemente impostato l'ID della nave nel motore senza effettuare ulteriori controlli
        motore.getShip().setId(motoreRequest.getShipId());

        return motore;
    }
}
