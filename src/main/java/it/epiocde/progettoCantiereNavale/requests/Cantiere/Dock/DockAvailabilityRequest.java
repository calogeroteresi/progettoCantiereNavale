package it.epiocde.progettoCantiereNavale.requests.Cantiere.Dock;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import java.time.LocalDate;

@Data
public class DockAvailabilityRequest {
    @NotNull(message = "L'ID del molo è richiesto")
    private Long dockId;

    @PositiveOrZero(message = "Il numero dei posti occupati deve essere un numero positivo o zero")
    private int postiOccupati;

    @PositiveOrZero(message = "Il numero dei posti disponibili deve essere un numero positivo o zero")
    private int postiDisponibili;

    private boolean disponibile;

    private boolean inManutenzione;

    private LocalDate dataInizio;

    private LocalDate dataFine;

    private boolean riduzioneCapacitaDovutaAllaManutenzione;

    @PositiveOrZero(message = "La capacità ridotta deve essere un numero positivo o zero")
    private int capacitaRidotta;
}
