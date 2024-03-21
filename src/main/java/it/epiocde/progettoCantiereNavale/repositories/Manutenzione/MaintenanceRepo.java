package it.epiocde.progettoCantiereNavale.repositories.Manutenzione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Manutenzione.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepo extends JpaRepository<Maintenance, Long>, PagingAndSortingRepository<Maintenance, Long> {
}
