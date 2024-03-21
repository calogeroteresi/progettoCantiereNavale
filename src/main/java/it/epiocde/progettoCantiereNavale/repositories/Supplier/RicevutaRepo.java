package it.epiocde.progettoCantiereNavale.repositories.Supplier;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Supplier.Ricevuta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RicevutaRepo extends JpaRepository<Ricevuta, Long>, PagingAndSortingRepository<Ricevuta, Long> {
}
