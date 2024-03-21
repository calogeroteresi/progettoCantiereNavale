package it.epiocde.progettoCantiereNavale.repositories.Clienti;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long>, PagingAndSortingRepository<Reservation, Long> {
    // Aggiungi eventuali metodi personalizzati per l'interazione con le prenotazioni dei clienti, se necessario
}
