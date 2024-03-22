package it.epiocde.progettoCantiereNavale.requests.Cantiere.Supplier;

import lombok.Data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
public class RicevutaRequest {
    @NotNull(message = "La data della ricevuta è richiesta")
    private LocalDate dataRicevuta;

    @NotBlank(message = "Il numero della ricevuta è richiesto")
    private String numeroRicevuta;

    @NotNull(message = "L'importo totale è richiesto")
    private double importoTotale;

    @NotNull(message = "L'ID della fattura fornitore è richiesto")
    private Long fatturaFornitoreId;

    @NotNull(message = "L'ID del fornitore è richiesto")
    private Long supplierId;

    @Valid
    @NotNull(message = "I dettagli degli acquisti sono richiesti")
    private List<DettaglioAcquistoRequest> dettagliAcquisti;
}
