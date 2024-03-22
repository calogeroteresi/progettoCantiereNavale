package it.epiocde.progettoCantiereNavale.requests.Cantiere.Manutenzione;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskManutenzioneRequest {
    @NotBlank(message = "La descrizione è richiesta")
    private String descrizione;

    private String dettagli;

    private boolean completato;

    private Long maintenanceId;
}
