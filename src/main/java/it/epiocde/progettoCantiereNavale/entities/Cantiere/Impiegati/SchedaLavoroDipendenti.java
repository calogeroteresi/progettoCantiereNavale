package it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione.IncidentReport;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "schede_lavoro_dipendenti")
public class SchedaLavoroDipendenti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dataLavoro;

    private String attivita;

    private int oreLavorate;

    @ManyToMany
    @JoinTable(
            name = "dipendenti_schede_lavoro",
            joinColumns = @JoinColumn(name = "scheda_lavoro_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Set<Employee> dipendenti = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @OneToMany(mappedBy = "schedaLavoroDipendenti")
    private List<IncidentReport> incidentReports;
}
