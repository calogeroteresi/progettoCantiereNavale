package it.epiocde.progettoCantiereNavale.services.Cantiere.Magazzino;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Magazzino.ArticoloMagazzinoMotore;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Magazzino.ArticoloMagazzino;
import it.epiocde.progettoCantiereNavale.entities.Ship.Motore;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.Magazzino.ArticoloMagazzinoMotoriRepo;
import it.epiocde.progettoCantiereNavale.repositories.Magazzino.ArticoloMagazzinoRepo;
import it.epiocde.progettoCantiereNavale.repositories.Ship.MotoreRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Magazzino.ArticoloMagazzinoMotoreRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticoloMagazzinoMotoreService {

    @Autowired
    private ArticoloMagazzinoMotoriRepo articoloMagazzinoMotoreRepository;

    @Autowired
    private ArticoloMagazzinoRepo articoloMagazzinoRepository;

    @Autowired
    private MotoreRepo motoreRepository;

    public List<ArticoloMagazzinoMotore> getAllArticoliMagazzinoMotori() {
        return articoloMagazzinoMotoreRepository.findAll();
    }

    public Optional<ArticoloMagazzinoMotore> getArticoloMagazzinoMotoreById(Long id) {
        return articoloMagazzinoMotoreRepository.findById(id);
    }

    public ArticoloMagazzinoMotore createArticoloMagazzinoMotore(ArticoloMagazzinoMotoreRequest request) throws NotFoundException {
        ArticoloMagazzino articoloMagazzino = articoloMagazzinoRepository.findById(request.getArticoloMagazzinoId())
                .orElseThrow(() -> new NotFoundException("Articolo di magazzino non trovato con ID: " + request.getArticoloMagazzinoId()));

        Motore motore = motoreRepository.findById(request.getMotoreId())
                .orElseThrow(() -> new NotFoundException("Motore non trovato con ID: " + request.getMotoreId()));

        ArticoloMagazzinoMotore articoloMagazzinoMotore = new ArticoloMagazzinoMotore();
        articoloMagazzinoMotore.setArticoloMagazzino(articoloMagazzino);
        articoloMagazzinoMotore.setMotore(motore);

        return articoloMagazzinoMotoreRepository.save(articoloMagazzinoMotore);
    }

    public void deleteArticoloMagazzinoMotore(Long id) throws NotFoundException {
        ArticoloMagazzinoMotore articoloMagazzinoMotore = articoloMagazzinoMotoreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Articolo di magazzino del motore non trovato con ID: " + id));

        articoloMagazzinoMotoreRepository.delete(articoloMagazzinoMotore);
    }

    // Aggiungi altri metodi se necessario
}
