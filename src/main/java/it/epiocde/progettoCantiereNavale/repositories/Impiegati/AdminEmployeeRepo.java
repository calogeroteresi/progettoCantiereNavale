package it.epiocde.progettoCantiereNavale.repositories.Impiegati;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati.AdminEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminEmployeeRepo extends JpaRepository<AdminEmployee, Long>, PagingAndSortingRepository<AdminEmployee, Long> {
}
