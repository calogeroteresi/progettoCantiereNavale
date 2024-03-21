package it.epiocde.progettoCantiereNavale.entities.Cantiere.Manutenzione;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import lombok.Data;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Magazzino.ArticoloMagazzino;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione.IncidentReport;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati.Employee;
import it.epiocde.progettoCantiereNavale.entities.Ship.Ship;

@Data
@Entity
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    @Temporal(TemporalType.DATE)
    private Date dataInizio;
    @Temporal(TemporalType.DATE)
    private Date dataFine;
    private String descrizione;
    private double costo;

    @ManyToOne
    @JoinColumn(name = "ship_id")
    private Ship ship;

    @OneToMany(mappedBy = "maintenance")
    private List<TaskManutenzione> tasks;

    @ManyToOne
    @JoinColumn(name = "incident_report_id")
    private IncidentReport incidentReport;

    @ManyToMany
    @JoinTable(
            name = "maintenance_employee",
            joinColumns = @JoinColumn(name = "maintenance_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employees;

    @OneToMany(mappedBy = "maintenance")
    private List<MaterialeUtilizzatoManutenzione> materialiUtilizzati;
}
