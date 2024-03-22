package it.epiocde.progettoCantiereNavale.requests.Cantiere.Manutenzione;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskManutenzioneRequest {
    @NotBlank(message = "La descrizione è richiesta")
    private String descrizione;

    private String dettagli;

    private boolean completato;

    @NotNull(message = "L'ID della manutenzione è richiesto")
    private Long maintenanceId;
}
