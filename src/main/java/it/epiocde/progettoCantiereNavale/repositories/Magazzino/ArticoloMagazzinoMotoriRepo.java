package it.epiocde.progettoCantiereNavale.repositories.Magazzino;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Magazzino.ArticoloMagazzinoMotore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticoloMagazzinoMotoriRepo extends JpaRepository<ArticoloMagazzinoMotore, Long>, PagingAndSortingRepository<ArticoloMagazzinoMotore, Long> {
}
