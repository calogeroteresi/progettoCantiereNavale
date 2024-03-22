package it.epiocde.progettoCantiereNavale.requests.Cantiere.Gestione;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.Date;

@Data
public class WeatherForecastRequest {
    private Date forecastDate;

    @NotBlank(message = "La località è richiesta")
    private String location;

    private Double temperature;

    @NotBlank(message = "La descrizione è richiesta")
    private String description;

    // Aggiungi altri campi se necessario
}
