package it.epiocde.progettoCantiereNavale.requests.Cantiere.Gestione;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import java.util.Date;

@Data
public class WeatherForecastRequest {
    @NotNull(message = "La data della previsione è richiesta")
    @PastOrPresent(message = "La data della previsione deve essere nel passato o nel presente")
    private Date forecastDate;

    @NotBlank(message = "La località è richiesta")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Il formato della località non è valido")
    private String location;

    @DecimalMin(value = "-273.15", inclusive = true, message = "La temperatura minima accettabile è -273.15°C (zero assoluto)")
    @DecimalMax(value = "100.0", inclusive = true, message = "La temperatura massima accettabile è 100°C")
    private Double temperature;

    @NotBlank(message = "La descrizione è richiesta")
    private String description;

    // Aggiungi altre validazioni se necessario

    // Aggiungi altri campi se necessario
}
