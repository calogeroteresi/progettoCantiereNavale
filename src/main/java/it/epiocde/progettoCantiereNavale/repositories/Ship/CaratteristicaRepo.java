package it.epiocde.progettoCantiereNavale.repositories.Ship;

import it.epiocde.progettoCantiereNavale.entities.Ship.Caratteristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaratteristicaRepo extends JpaRepository<Caratteristica, Long>, PagingAndSortingRepository<Caratteristica, Long> {
}
