package it.epiocde.progettoCantiereNavale.requests.Cantiere.Clienti;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class ReservationRequest {
    @NotNull(message = "La data di prenotazione è richiesta")
    private Date dataPrenotazione;

    @NotNull(message = "La data di inizio è richiesta")
    private Date dataInizio;

    @NotNull(message = "La data di fine è richiesta")
    private Date dataFine;

    private boolean confermata;

    // Aggiungi altri campi se necessario

    private Long customerId;

    private Long dockAvailabilityId;

    // Aggiungi altri campi se necessario
}
