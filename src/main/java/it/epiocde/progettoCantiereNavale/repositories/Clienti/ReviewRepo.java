package it.epiocde.progettoCantiereNavale.repositories.Clienti;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long>, PagingAndSortingRepository<Review, Long> {
}
