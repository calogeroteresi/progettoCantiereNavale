package it.epiocde.progettoCantiereNavale.repositories.Impiegati;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>, PagingAndSortingRepository<Employee, Long> {
}
