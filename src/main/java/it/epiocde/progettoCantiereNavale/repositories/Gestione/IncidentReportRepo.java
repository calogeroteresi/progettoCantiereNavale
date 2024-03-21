package it.epiocde.progettoCantiereNavale.repositories.Gestione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione.IncidentReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentReportRepo extends JpaRepository<IncidentReport, Long>, PagingAndSortingRepository<IncidentReport, Long> {
}
