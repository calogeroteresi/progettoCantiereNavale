package it.epiocde.progettoCantiereNavale.requests.Cantiere.Supplier;

import it.epiocde.progettoCantiereNavale.enums.TipoArticolo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DettaglioAcquistoRequest {
    @NotNull(message = "L'ID della ricevuta è richiesto")
    private Long ricevutaId;

    @NotBlank(message = "Il nome del materiale è richiesto")
    private String nomeMateriale;

    @NotNull(message = "La quantità è richiesta")
    private int quantita;

    @NotNull(message = "Il prezzo unitario è richiesto")
    private double prezzoUnitario;

    @NotNull(message = "Il tipo di articolo è richiesto")
    private TipoArticolo tipo;
}
