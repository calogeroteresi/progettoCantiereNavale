package it.epiocde.progettoCantiereNavale.services.Cantiere.Supplier;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Supplier.DettaglioAcquisto;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Supplier.Ricevuta;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.Supplier.DettaglioAcquistoRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Supplier.DettaglioAcquistoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DettaglioAcquistoService {

    @Autowired
    private DettaglioAcquistoRepo dettaglioAcquistoRepository;

    @Autowired
    private RicevutaService ricevutaService;

    public DettaglioAcquisto createDettaglioAcquisto(DettaglioAcquistoRequest request) throws NotFoundException {
        DettaglioAcquisto dettaglioAcquisto = new DettaglioAcquisto();
        dettaglioAcquisto.setNomeMateriale(request.getNomeMateriale());
        dettaglioAcquisto.setQuantita(request.getQuantita());
        dettaglioAcquisto.setPrezzoUnitario(request.getPrezzoUnitario());
        dettaglioAcquisto.setTipo(request.getTipo());

        // Ottieni la ricevuta
        Ricevuta ricevuta = ricevutaService.getRicevutaById(request.getRicevutaId());
        dettaglioAcquisto.setRicevuta(ricevuta);

        return dettaglioAcquistoRepository.save(dettaglioAcquisto);
    }

    public void deleteDettaglioAcquisto(Long id) throws NotFoundException {
        DettaglioAcquisto dettaglioAcquisto = getDettaglioAcquistoById(id);
        dettaglioAcquistoRepository.delete(dettaglioAcquisto);
    }

    public DettaglioAcquisto getDettaglioAcquistoById(Long id) throws NotFoundException {
        return dettaglioAcquistoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Dettaglio acquisto non trovato"));
    }

    public DettaglioAcquisto updateDettaglioAcquisto(Long id, DettaglioAcquistoRequest request) throws NotFoundException {
        DettaglioAcquisto dettaglioAcquisto = getDettaglioAcquistoById(id);
        dettaglioAcquisto.setNomeMateriale(request.getNomeMateriale());
        dettaglioAcquisto.setQuantita(request.getQuantita());
        dettaglioAcquisto.setPrezzoUnitario(request.getPrezzoUnitario());
        dettaglioAcquisto.setTipo(request.getTipo());

        // Aggiorna la ricevuta se necessario
        if (!dettaglioAcquisto.getRicevuta().getId().equals(request.getRicevutaId())) {
            Ricevuta ricevuta = ricevutaService.getRicevutaById(request.getRicevutaId());
            dettaglioAcquisto.setRicevuta(ricevuta);
        }

        return dettaglioAcquistoRepository.save(dettaglioAcquisto);
    }
}
