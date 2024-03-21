package it.epiocde.progettoCantiereNavale.repositories.Supplier;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Supplier.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier, Long>, PagingAndSortingRepository<Supplier, Long> {
}
