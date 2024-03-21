package it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione;

import javax.persistence.*;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati.Employee;
import it.epiocde.progettoCantiereNavale.enums.IncidentStatus;
import lombok.Data;
import java.util.Date;

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

}
