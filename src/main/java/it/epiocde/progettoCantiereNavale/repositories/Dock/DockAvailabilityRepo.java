package it.epiocde.progettoCantiereNavale.repositories.Dock;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Dock.DockAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DockAvailabilityRepo extends JpaRepository<DockAvailability, Long>, PagingAndSortingRepository<DockAvailability, Long> {
}
