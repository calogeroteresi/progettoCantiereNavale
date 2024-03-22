package it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione.ServiceOffering;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati.Job;
import it.epiocde.progettoCantiereNavale.entities.User.Customer;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "customer_feedback")
public class CustomerFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String commento;
    private int valutazione;
    private Date dataFeedback;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_offering_id")
    private ServiceOffering serviceOffering;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
}
