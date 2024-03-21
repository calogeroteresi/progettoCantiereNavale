package it.epiocde.progettoCantiereNavale.repositories.Clienti;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti.OrderCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCustomerRepo extends JpaRepository<OrderCustomer, Long>, PagingAndSortingRepository<OrderCustomer, Long> {
    // Aggiungi eventuali metodi personalizzati per l'interazione con gli ordini dei clienti, se necessario
}
