package it.epiocde.progettoCantiereNavale.requests.Cantiere.Impiegati;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@Data
public class JobRequest {
    @NotBlank(message = "Il titolo è richiesto")
    private String titolo;

    @NotBlank(message = "La descrizione è richiesta")
    private String descrizione;

    @NotNull(message = "La data di inizio è richiesta")
    private Date dataInizio;

    @NotNull(message = "La data di fine è richiesta")
    private Date dataFine;

    @NotBlank(message = "Lo stato è richiesto")
    private String stato;

    // Aggiungi altri campi se necessario
}
