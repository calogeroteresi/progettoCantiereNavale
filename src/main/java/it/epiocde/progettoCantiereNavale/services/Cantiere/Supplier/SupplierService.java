package it.epiocde.progettoCantiereNavale.services.Cantiere.Supplier;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Supplier.Supplier;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.repositories.Supplier.SupplierRepo;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Supplier.SupplierRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepo supplierRepository;

    public Supplier getSupplierById(Long id) throws NotFoundException {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (!optionalSupplier.isPresent()) {
            throw new NotFoundException("Supplier not found with ID: " + id);
        }
        return optionalSupplier.get();
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier createSupplier(SupplierRequest supplierRequest) {
        Supplier supplier = new Supplier();
        mapSupplierRequestToEntity(supplierRequest, supplier);
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Long id, SupplierRequest supplierRequest) throws NotFoundException {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (!optionalSupplier.isPresent()) {
            throw new NotFoundException("Supplier not found with ID: " + id);
        }
        Supplier supplier = optionalSupplier.get();
        mapSupplierRequestToEntity(supplierRequest, supplier);
        return supplierRepository.save(supplier);
    }

    public void deleteSupplier(Long id) throws NotFoundException {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (!optionalSupplier.isPresent()) {
            throw new NotFoundException("Supplier not found with ID: " + id);
        }
        supplierRepository.deleteById(id);
    }

    private void mapSupplierRequestToEntity(SupplierRequest request, Supplier entity) {
        entity.setNome(request.getNome());
        entity.setInformazioniContatto(request.getInformazioniContatto());
        entity.setTipoProdottiForniti(request.getTipoProdottiForniti());
    }
}
