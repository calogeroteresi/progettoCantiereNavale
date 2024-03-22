package it.epiocde.progettoCantiereNavale.requests.Cantiere.Gestione;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class NotificationRequest {
    @NotBlank(message = "Il messaggio è richiesto")
    private String message;

    @NotNull(message = "La data di creazione è richiesta")
    private Date createdAt;

    private Long incidentReportId;

    private Long serviceOfferingId;

    private Long securityLogId;

    // Aggiungi altri campi se necessario
}
