package it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione;


import it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati.Employee;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati.Job;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati.SchedaLavoroDipendenti;
import it.epiocde.progettoCantiereNavale.enums.IncidentStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "incident_reports")
public class IncidentReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Temporal(TemporalType.TIMESTAMP)
    private Date reportedAt;

    private String description;

    private String location;


    @Enumerated(EnumType.STRING)
    private IncidentStatus status;

    @ManyToOne
    @JoinColumn(name = "reported_by_id")
    private Employee reportedBy;

    @ManyToOne
    @JoinColumn(name = "notification_id")
    private Notification notification;

    @ManyToOne
    @JoinColumn(name = "service_offering_id")
    private ServiceOffering serviceOffering;

    @ManyToOne
    @JoinColumn(name = "security_log_id")
    private SecurityLog securityLog;

    @ManyToOne
    @JoinColumn(name = "weather_forecast_id")
    private WeatherForecast weatherForecast;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;


    @ManyToOne
    @JoinColumn(name = "schedaLavoro_id")
    private SchedaLavoroDipendenti schedaLavoroDipendenti;

}
