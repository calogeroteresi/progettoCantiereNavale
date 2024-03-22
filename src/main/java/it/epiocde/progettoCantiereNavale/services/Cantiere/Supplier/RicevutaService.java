package it.epiocde.progettoCantiereNavale.services.Cantiere.Supplier;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza.FatturaFornitore;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Supplier.DettaglioAcquisto;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Supplier.Ricevuta;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Supplier.Supplier;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.Supplier.RicevutaRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Supplier.DettaglioAcquistoRequest;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Supplier.RicevutaRequest;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Finanza.FatturaFornitoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RicevutaService {

    @Autowired
    private RicevutaRepo ricevutaRepository;

    @Autowired
    private FatturaFornitoreService fatturaFornitoreService;

    @Autowired
    private SupplierService supplierService;

    public Ricevuta createRicevuta(RicevutaRequest request) throws NotFoundException {
        Ricevuta ricevuta = new Ricevuta();
        ricevuta.setDataRicevuta(request.getDataRicevuta());
        ricevuta.setNumeroRicevuta(request.getNumeroRicevuta());
        ricevuta.setImportoTotale(request.getImportoTotale());

        // Ottieni la fattura fornitore
        FatturaFornitore fatturaFornitore = fatturaFornitoreService.getFatturaFornitoreById(request.getFatturaFornitoreId());
        ricevuta.setFatturaFornitore(fatturaFornitore);

        // Ottieni il fornitore
        Supplier supplier = supplierService.getSupplierById(request.getSupplierId());
        ricevuta.setSupplier(supplier);

        // Crea i dettagli acquisto
        List<DettaglioAcquistoRequest> dettagliAcquistiRequest = request.getDettagliAcquisti();
        for (DettaglioAcquistoRequest dettaglioAcquistoRequest : dettagliAcquistiRequest) {
            DettaglioAcquisto dettaglioAcquisto = new DettaglioAcquisto();
            dettaglioAcquisto.setNomeMateriale(dettaglioAcquistoRequest.getNomeMateriale());
            dettaglioAcquisto.setQuantita(dettaglioAcquistoRequest.getQuantita());
            dettaglioAcquisto.setPrezzoUnitario(dettaglioAcquistoRequest.getPrezzoUnitario());
            dettaglioAcquisto.setTipo(dettaglioAcquistoRequest.getTipo());
            dettaglioAcquisto.setRicevuta(ricevuta);
            ricevuta.getDettagliAcquisti().add(dettaglioAcquisto);
        }

        return ricevutaRepository.save(ricevuta);
    }

    public void deleteRicevuta(Long id) throws NotFoundException {
        Ricevuta ricevuta = getRicevutaById(id);
        ricevutaRepository.delete(ricevuta);
    }

    public Ricevuta getRicevutaById(Long id) throws NotFoundException {
        return ricevutaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ricevuta non trovata"));
    }
}
