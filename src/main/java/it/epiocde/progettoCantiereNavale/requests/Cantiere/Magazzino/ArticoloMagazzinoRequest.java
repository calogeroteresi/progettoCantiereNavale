package it.epiocde.progettoCantiereNavale.requests.Cantiere.Magazzino;

import it.epiocde.progettoCantiereNavale.enums.TipoArticolo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ArticoloMagazzinoRequest {
    @NotBlank(message = "Il codice è richiesto")
    private String codice;

    @NotBlank(message = "La descrizione è richiesta")
    private String descrizione;

    @NotNull(message = "Il prezzo unitario è richiesto")
    private Double prezzoUnitario;

    @NotNull(message = "La quantità disponibile è richiesta")
    private Integer quantitaDisponibile;

    @NotNull(message = "L'ID del magazzino è richiesto")
    private Long magazzinoId;

    @NotNull(message = "Il tipo di articolo è richiesto")
    private TipoArticolo tipo;

    @NotNull(message = "L'ID della fattura fornitore è richiesto")
    private Long fatturaFornitoreId;

    // Aggiungi altri campi se necessario
}
