package it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "incident_report_id")
    private IncidentReport incidentReport;

    @ManyToOne
    @JoinColumn(name = "service_offering_id")
    private ServiceOffering serviceOffering;

    @ManyToOne
    @JoinColumn(name = "security_log_id")
    private SecurityLog securityLog;

    @ManyToOne
    @JoinColumn(name = "weather_forecast_id")
    private WeatherForecast weatherForecast;
}
