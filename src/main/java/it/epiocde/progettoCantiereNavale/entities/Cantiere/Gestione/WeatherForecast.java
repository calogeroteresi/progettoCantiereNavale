package it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
@Entity
@Table(name = "weather_forecasts")
public class WeatherForecast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date forecastDate;

    private String location;

    private Double temperature;

    private String description;

    // Collegamento con gli incidenti segnalati in caso di cattivo tempo
    @OneToMany(mappedBy = "weatherForecast")
    private List<IncidentReport> relatedIncidentReports;

    // Collegamento con le notifiche riguardanti il cattivo tempo
    @OneToMany(mappedBy = "weatherForecast")
    private List<Notification> relatedNotifications;
}
