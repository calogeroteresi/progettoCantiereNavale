package it.epiocde.progettoCantiereNavale.requests.Cantiere.Gestione;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class SecurityLogRequest {
    @NotNull(message = "Il timestamp è richiesto")
    private Date timestamp;

    @NotBlank(message = "L'azione è richiesta")
    private String action;

    private String description;

    private Long incidentReportId;

    private Long notificationId;

    // Aggiungi altri campi se necessario
}
