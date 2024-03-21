package it.epiocde.progettoCantiereNavale.repositories.Dock;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Dock.Dock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DockRepo extends JpaRepository<Dock, Long>, PagingAndSortingRepository<Dock, Long> {
}
