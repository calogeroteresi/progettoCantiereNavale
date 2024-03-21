package it.epiocde.progettoCantiereNavale.repositories.Finanza;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza.FatturaFornitore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FatturaFornitoreRepo extends JpaRepository<FatturaFornitore, Long>, PagingAndSortingRepository<FatturaFornitore, Long> {
}
