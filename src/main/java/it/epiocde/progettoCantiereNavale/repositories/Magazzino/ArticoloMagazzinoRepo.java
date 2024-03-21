package it.epiocde.progettoCantiereNavale.repositories.Magazzino;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Magazzino.ArticoloMagazzino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticoloMagazzinoRepo extends JpaRepository<ArticoloMagazzino, Long>, PagingAndSortingRepository<ArticoloMagazzino, Long> {
}
