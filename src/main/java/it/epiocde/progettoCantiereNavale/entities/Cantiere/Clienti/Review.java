package it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione.ServiceOffering;
import it.epiocde.progettoCantiereNavale.entities.User.Customer;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String testoRecensione;
    private int valutazione; // Può essere un valore numerico da 1 a 5 per esempio
    private Date dataRecensione;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_offering_id")
    private ServiceOffering serviceOffering;
}
