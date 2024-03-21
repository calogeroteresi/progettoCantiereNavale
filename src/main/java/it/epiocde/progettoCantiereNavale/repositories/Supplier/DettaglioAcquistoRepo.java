package it.epiocde.progettoCantiereNavale.repositories.Supplier;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Supplier.DettaglioAcquisto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DettaglioAcquistoRepo extends JpaRepository<DettaglioAcquisto, Long>, PagingAndSortingRepository<DettaglioAcquisto, Long> {
}
