package it.epiocde.progettoCantiereNavale.repositories.User;

import it.epiocde.progettoCantiereNavale.entities.User.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>, PagingAndSortingRepository<Customer, Long> {
}
