package it.epiocde.progettoCantiereNavale.repositories.Manutenzione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Manutenzione.MaterialeUtilizzatoManutenzione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialeUtilizzatoManutenzioneRepo extends JpaRepository<MaterialeUtilizzatoManutenzione, Long>, PagingAndSortingRepository<MaterialeUtilizzatoManutenzione, Long> {
}
