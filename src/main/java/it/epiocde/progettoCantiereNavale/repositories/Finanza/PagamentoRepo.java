package it.epiocde.progettoCantiereNavale.repositories.Finanza;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepo extends JpaRepository<Pagamento, Long>, PagingAndSortingRepository<Pagamento, Long> {
}
