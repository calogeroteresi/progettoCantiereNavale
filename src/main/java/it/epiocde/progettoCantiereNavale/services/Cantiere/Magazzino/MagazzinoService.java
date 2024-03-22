package it.epiocde.progettoCantiereNavale.services.Cantiere.Magazzino;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Magazzino.Magazzino;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.Magazzino.MagazzinoRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Magazzino.MagazzinoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MagazzinoService {

    @Autowired
    private MagazzinoRepo magazzinoRepository;

    public List<Magazzino> getAllMagazzini() {
        return magazzinoRepository.findAll();
    }

    public Magazzino getMagazzinoById(Long id) throws NotFoundException {
        Optional<Magazzino> magazzinoOptional = magazzinoRepository.findById(id);
        if (magazzinoOptional.isEmpty()) {
            throw new NotFoundException("Magazzino non trovato con ID: " + id);
        }
        return magazzinoOptional.get();
    }

    public Magazzino createMagazzino(MagazzinoRequest request) {
        Magazzino magazzino = new Magazzino();
        mapMagazzinoRequestToEntity(request, magazzino);
        return magazzinoRepository.save(magazzino);
    }

    public Magazzino updateMagazzino(Long id, MagazzinoRequest request) throws NotFoundException {
        Magazzino magazzino = getMagazzinoById(id);
        mapMagazzinoRequestToEntity(request, magazzino);
        return magazzinoRepository.save(magazzino);
    }

    public void deleteMagazzino(Long id) throws NotFoundException {
        Magazzino magazzino = getMagazzinoById(id);
        magazzinoRepository.delete(magazzino);
    }

    private void mapMagazzinoRequestToEntity(MagazzinoRequest request, Magazzino magazzino) {
        magazzino.setNome(request.getNome());
        magazzino.setUbicazione(request.getUbicazione());
        magazzino.setDescrizione(request.getDescrizione());
    }
}
