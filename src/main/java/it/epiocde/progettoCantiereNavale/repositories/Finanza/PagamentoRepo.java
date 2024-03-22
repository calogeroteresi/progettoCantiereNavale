package it.epiocde.progettoCantiereNavale.repositories.Finanza;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza.Pagamento;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza.FatturaCliente;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza.FatturaFornitore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepo extends JpaRepository<Pagamento, Long> {

    List<Pagamento> findByFatturaCliente(FatturaCliente fatturaCliente);

    List<Pagamento> findByFatturaFornitore(FatturaFornitore fatturaFornitore);
}
