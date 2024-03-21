package it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti.CustomerFeedback;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione.IncidentReport;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titolo;
    private String descrizione;
    @Temporal(TemporalType.DATE)
    private Date dataInizio;
    @Temporal(TemporalType.DATE)
    private Date dataFine;
    private String stato;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "scheda_lavoro_id")
    private SchedaLavoroDipendenti schedaLavoro;

    @OneToMany(mappedBy = "job")
    private List<IncidentReport> incidentReports;

    @OneToMany(mappedBy = "job")
    private List<CustomerFeedback> customerReviews;


}
