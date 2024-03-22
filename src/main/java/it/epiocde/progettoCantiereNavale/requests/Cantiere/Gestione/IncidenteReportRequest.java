package it.epiocde.progettoCantiereNavale.requests.Cantiere.Gestione;

import it.epiocde.progettoCantiereNavale.enums.IncidentStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class IncidenteReportRequest {
    @NotNull(message = "La data della segnalazione è richiesta")
    private Date reportedAt;

    @NotBlank(message = "La descrizione è richiesta")
    private String description;

    @NotBlank(message = "La località è richiesta")
    private String location;

    @NotNull(message = "Lo stato dell'incidente è richiesto")
    private IncidentStatus status;

    private Long reportedById;

    private Long notificationId;

    private Long serviceOfferingId;

    private Long securityLogId;

    // Aggiungi altri campi se necessario
}
