package it.epiocde.progettoCantiereNavale.repositories.Ship;

import it.epiocde.progettoCantiereNavale.entities.Ship.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepo extends JpaRepository<Certificate, Long>, PagingAndSortingRepository<Certificate, Long> {
}
