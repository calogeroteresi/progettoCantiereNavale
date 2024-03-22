package it.epiocde.progettoCantiereNavale.services.Cantiere.Finanza;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza.FatturaFornitore;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.Finanza.FatturaFornitoreRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Finanza.FatturaFornitoreRequest;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FatturaFornitoreService {
    @Autowired
    private FatturaFornitoreRepo fatturaFornitoreRepository;

    @Autowired
    private SupplierService supplierService;

    public FatturaFornitore getFatturaFornitoreById(Long id) throws NotFoundException {
        Optional<FatturaFornitore> optionalFatturaFornitore = fatturaFornitoreRepository.findById(id);
        if (!optionalFatturaFornitore.isPresent()) {
            throw new NotFoundException("Fattura fornitore not found with ID: " + id);
        }
        return optionalFatturaFornitore.get();
    }

    public List<FatturaFornitore> getAllFattureFornitori() {
        return fatturaFornitoreRepository.findAll();
    }

    public FatturaFornitore createFatturaFornitore(FatturaFornitoreRequest fatturaFornitoreRequest) throws NotFoundException {
        FatturaFornitore fatturaFornitore = new FatturaFornitore();
        mapFatturaFornitoreRequestToEntity(fatturaFornitoreRequest, fatturaFornitore);
        return fatturaFornitoreRepository.save(fatturaFornitore);
    }

    public FatturaFornitore updateFatturaFornitore(Long id, FatturaFornitoreRequest fatturaFornitoreRequest) throws NotFoundException {
        Optional<FatturaFornitore> optionalFatturaFornitore = fatturaFornitoreRepository.findById(id);
        if (!optionalFatturaFornitore.isPresent()) {
            throw new NotFoundException("Fattura fornitore not found with ID: " + id);
        }
        FatturaFornitore fatturaFornitore = optionalFatturaFornitore.get();
        mapFatturaFornitoreRequestToEntity(fatturaFornitoreRequest, fatturaFornitore);
        return fatturaFornitoreRepository.save(fatturaFornitore);
    }

    public void deleteFatturaFornitore(Long id) throws NotFoundException {
        Optional<FatturaFornitore> optionalFatturaFornitore = fatturaFornitoreRepository.findById(id);
        if (!optionalFatturaFornitore.isPresent()) {
            throw new NotFoundException("Fattura fornitore not found with ID: " + id);
        }
        fatturaFornitoreRepository.deleteById(id);
    }

    private void mapFatturaFornitoreRequestToEntity(FatturaFornitoreRequest request, FatturaFornitore entity) throws NotFoundException {
        entity.setNumeroFattura(request.getNumeroFattura());
        entity.setDataEmissione(request.getDataEmissione());
        entity.setImportoTotale(request.getImportoTotale());
        entity.setStato(request.getStato());

        entity.setSupplier(supplierService.getSupplierById(request.getSupplierId()));
    }
}
