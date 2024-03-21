package it.epiocde.progettoCantiereNavale.repositories.Finanza;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza.FatturaCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FatturaClienteRepo extends JpaRepository<FatturaCliente, Long>, PagingAndSortingRepository<FatturaCliente, Long> {
}
