package it.epiocde.progettoCantiereNavale.entities.Cantiere.Gestione;

import javax.persistence.*;
import java.util.Date;
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
}
