package it.epiocde.progettoCantiereNavale.repositories.User;

import it.epiocde.progettoCantiereNavale.entities.User.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long>, PagingAndSortingRepository<Admin, Long> {
}
