package it.epiocde.progettoCantiereNavale.repositories.Manutenzione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Manutenzione.TaskManutenzione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskManutenzioneRepo extends JpaRepository<TaskManutenzione, Long>, PagingAndSortingRepository<TaskManutenzione, Long> {
}
