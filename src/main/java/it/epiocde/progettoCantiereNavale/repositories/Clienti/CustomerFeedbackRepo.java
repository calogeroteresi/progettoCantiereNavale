package it.epiocde.progettoCantiereNavale.repositories.Clienti;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti.CustomerFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerFeedbackRepo extends JpaRepository<CustomerFeedback, Long>, PagingAndSortingRepository<CustomerFeedback, Long> {
}
