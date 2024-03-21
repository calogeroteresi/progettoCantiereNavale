package it.epiocde.progettoCantiereNavale.repositories.Gestione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepo extends JpaRepository<Notification, Long>, PagingAndSortingRepository<Notification, Long> {
}
