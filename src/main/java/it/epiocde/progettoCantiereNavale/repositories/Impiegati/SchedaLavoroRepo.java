package it.epiocde.progettoCantiereNavale.repositories.Impiegati;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati.SchedaLavoroDipendenti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedaLavoroRepo extends JpaRepository<SchedaLavoroDipendenti, Long>, PagingAndSortingRepository<SchedaLavoroDipendenti, Long> {
}
