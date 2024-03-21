package it.epiocde.progettoCantiereNavale.repositories.Gestione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione.SecurityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityLogRepo extends JpaRepository<SecurityLog, Long>, PagingAndSortingRepository<SecurityLog, Long> {
}
