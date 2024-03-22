package it.epiocde.progettoCantiereNavale.controllers.Cantiere.Supplier;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Supplier.Supplier;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.Cantiere.Supplier.SupplierRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.Cantiere.Supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public ResponseEntity<DefaultResponse> getAllSuppliers() {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        return DefaultResponse.noMessage(suppliers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getSupplierById(@PathVariable Long id) throws NotFoundException {
        Supplier supplier = supplierService.getSupplierById(id);
        return DefaultResponse.noMessage(supplier, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> createSupplier(@RequestBody @Validated SupplierRequest supplierRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Supplier createdSupplier = supplierService.createSupplier(supplierRequest);
        return DefaultResponse.noMessage(createdSupplier, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteSupplier(@PathVariable Long id) throws NotFoundException {
        supplierService.deleteSupplier(id);
        String message = "Supplier with ID " + id + " has been deleted";
        return DefaultResponse.noObject(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateSupplier(@PathVariable Long id, @RequestBody @Validated SupplierRequest supplierRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().toString());
        }
        Supplier updatedSupplier = supplierService.updateSupplier(id, supplierRequest);
        return DefaultResponse.noMessage(updatedSupplier, HttpStatus.OK);
    }
}
