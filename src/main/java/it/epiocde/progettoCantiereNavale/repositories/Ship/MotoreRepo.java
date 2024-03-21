package it.epiocde.progettoCantiereNavale.repositories.Ship;

import it.epiocde.progettoCantiereNavale.entities.Ship.Motore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoreRepo extends JpaRepository<Motore, Long>, PagingAndSortingRepository<Motore, Long> {
}
