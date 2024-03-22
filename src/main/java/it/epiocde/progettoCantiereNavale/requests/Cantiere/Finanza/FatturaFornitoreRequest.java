package it.epiocde.progettoCantiereNavale.requests.Cantiere.Finanza;

import it.epiocde.progettoCantiereNavale.enums.StatoFattura;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.Date;

@Data
public class FatturaFornitoreRequest {
    @NotBlank(message = "Il numero della fattura è richiesto")
    private String numeroFattura;

    @NotNull(message = "La data di emissione è richiesta")
    private Date dataEmissione;

    @NotNull(message = "L'importo totale è richiesto")
    private Double importoTotale;

    @NotNull(message = "Lo stato della fattura è richiesto")
    private StatoFattura stato;

    @NotNull(message = "L'ID del fornitore è richiesto")
    private Long supplierId;

    // Aggiungi altri campi se necessario
}
