package it.epiocde.progettoCantiereNavale.repositories.Ship;

import it.epiocde.progettoCantiereNavale.entities.Ship.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepo extends JpaRepository<Ship, Long>, PagingAndSortingRepository<Ship, Long> {
}

