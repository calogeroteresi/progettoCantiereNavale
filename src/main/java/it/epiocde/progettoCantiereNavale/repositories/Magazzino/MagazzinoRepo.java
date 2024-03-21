package it.epiocde.progettoCantiereNavale.repositories.Magazzino;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Magazzino.Magazzino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagazzinoRepo extends JpaRepository<Magazzino, Long>, PagingAndSortingRepository<Magazzino, Long> {
}
