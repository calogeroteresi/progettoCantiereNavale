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

    @NotNull(message = "L'ID del cliente è richiesto")
    private Long customerId;

    @NotNull(message = "L'ID della disponibilità del molo è richiesto")
    private Long dockAvailabilityId;
}
