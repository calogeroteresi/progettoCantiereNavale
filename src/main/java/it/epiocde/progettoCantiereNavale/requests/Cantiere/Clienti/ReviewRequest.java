package it.epiocde.progettoCantiereNavale.requests.Cantiere.Clienti;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class ReviewRequest {
    @NotBlank(message = "Il testo della recensione è richiesto")
    private String testoRecensione;

    @NotNull(message = "La valutazione è richiesta")
    private int valutazione; // Può essere un valore numerico da 1 a 5 per esempio

    @NotNull(message = "La data della recensione è richiesta")
    private Date dataRecensione;

    @NotNull(message = "L'ID del cliente è richiesto")
    private Long customerId;

    @NotNull(message = "L'ID dell'offerta di servizio è richiesto")
    private Long serviceOfferingId;
}
