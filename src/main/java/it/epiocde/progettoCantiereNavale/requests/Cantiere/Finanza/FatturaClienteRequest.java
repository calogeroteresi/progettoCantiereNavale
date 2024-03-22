package it.epiocde.progettoCantiereNavale.requests.Cantiere.Finanza;

import it.epiocde.progettoCantiereNavale.enums.StatoFattura;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.Date;

@Data
public class FatturaClienteRequest {
    @NotBlank(message = "Il numero della fattura è richiesto")
    private String numeroFattura;

    @NotNull(message = "La data di emissione è richiesta")
    private Date dataEmissione;

    @NotNull(message = "L'importo totale è richiesto")
    private Double importoTotale;

    @NotNull(message = "Lo stato della fattura è richiesto")
    private StatoFattura stato;

    @NotNull(message = "L'ID del cliente è richiesto")
    private Long customerId;

    @NotNull(message = "L'ID dell'ordine è richiesto")
    private Long orderId;

    // Aggiungi altri campi se necessario
}
