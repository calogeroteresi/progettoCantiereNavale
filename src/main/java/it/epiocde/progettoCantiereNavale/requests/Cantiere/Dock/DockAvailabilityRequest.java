package it.epiocde.progettoCantiereNavale.requests.Cantiere.Dock;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class DockAvailabilityRequest {
    @NotNull(message = "L'ID del molo è richiesto")
    private Long dockId;

    private int postiOccupati;

    private int postiDisponibili;

    private boolean disponibile;

    private boolean inManutenzione;

    private LocalDate dataInizio;

    private LocalDate dataFine;

    private boolean riduzioneCapacitaDovutaAllaManutenzione;

    private int capacitaRidotta;

    // Aggiungi altri campi se necessario
}
