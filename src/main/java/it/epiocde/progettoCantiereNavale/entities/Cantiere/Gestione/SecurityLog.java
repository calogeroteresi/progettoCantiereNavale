package it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "security_logs")
@Data
public class SecurityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    private String action;

    private String description;

    @ManyToOne
    @JoinColumn(name = "incident_report_id")
    private IncidentReport incidentReport;

    @ManyToOne
    @JoinColumn(name = "notification_id")
    private Notification notification;
}
