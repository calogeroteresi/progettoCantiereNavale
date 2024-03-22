package it.epiocde.progettoCantiereNavale.services.Cantiere.Magazzino;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Magazzino.ArticoloMagazzino;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.Magazzino.ArticoloMagazzinoRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Magazzino.ArticoloMagazzinoRequest;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Finanza.FatturaFornitoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticoloMagazzinoService {

    @Autowired
    private ArticoloMagazzinoRepo articoloMagazzinoRepository;

    @Autowired
    private MagazzinoService magazzinoService;

    @Autowired
    private FatturaFornitoreService fatturaFornitoreService;

    public List<ArticoloMagazzino> getAllArticoliMagazzino() {
        return articoloMagazzinoRepository.findAll();
    }

    public ArticoloMagazzino getArticoloMagazzinoById(Long id) throws NotFoundException {
        Optional<ArticoloMagazzino> articoloMagazzinoOptional = articoloMagazzinoRepository.findById(id);
        if (articoloMagazzinoOptional.isEmpty()) {
            throw new NotFoundException("Articolo di magazzino non trovato con ID: " + id);
        }
        return articoloMagazzinoOptional.get();
    }

    public ArticoloMagazzino createArticoloMagazzino(ArticoloMagazzinoRequest request) throws NotFoundException {
        ArticoloMagazzino articoloMagazzino = new ArticoloMagazzino();
        mapArticoloMagazzinoRequestToEntity(request, articoloMagazzino);
        return articoloMagazzinoRepository.save(articoloMagazzino);
    }

    public ArticoloMagazzino updateArticoloMagazzino(Long id, ArticoloMagazzinoRequest request) throws NotFoundException {
        ArticoloMagazzino articoloMagazzino = getArticoloMagazzinoById(id);
        mapArticoloMagazzinoRequestToEntity(request, articoloMagazzino);
        return articoloMagazzinoRepository.save(articoloMagazzino);
    }

    public void deleteArticoloMagazzino(Long id) throws NotFoundException {
        ArticoloMagazzino articoloMagazzino = getArticoloMagazzinoById(id);
        articoloMagazzinoRepository.delete(articoloMagazzino);
    }

    private void mapArticoloMagazzinoRequestToEntity(ArticoloMagazzinoRequest request, ArticoloMagazzino articoloMagazzino) throws NotFoundException {
        articoloMagazzino.setCodice(request.getCodice());
        articoloMagazzino.setDescrizione(request.getDescrizione());
        articoloMagazzino.setPrezzoUnitario(request.getPrezzoUnitario());
        articoloMagazzino.setQuantitaDisponibile(request.getQuantitaDisponibile());
        articoloMagazzino.setMagazzino(magazzinoService.getMagazzinoById(request.getMagazzinoId()));
        articoloMagazzino.setTipo(request.getTipo());
        articoloMagazzino.setFatturaFornitore(fatturaFornitoreService.getFatturaFornitoreById(request.getFatturaFornitoreId()));
    }
}
