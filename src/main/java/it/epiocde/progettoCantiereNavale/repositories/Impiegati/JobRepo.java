package it.epiocde.progettoCantiereNavale.repositories.Impiegati;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<Job, Long>, PagingAndSortingRepository<Job, Long> {
}
