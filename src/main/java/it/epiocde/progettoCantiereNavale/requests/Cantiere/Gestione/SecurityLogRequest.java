package it.epiocde.progettoCantiereNavale.requests.Cantiere.Gestione;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class SecurityLogRequest {
    @NotNull(message = "Il timestamp è richiesto")
    private Date timestamp;

    @NotBlank(message = "L'azione è richiesta")
    private String action;

    @Size(max = 255, message = "La descrizione deve essere lunga al massimo 255 caratteri")
    private String description;

    private Long incidentReportId;

    private Long notificationId;
}
