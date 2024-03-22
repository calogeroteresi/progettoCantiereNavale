package it.epiocde.progettoCantiereNavale.requests.Cantiere.Magazzino;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ArticoloMagazzinoMotoreRequest {
    @NotNull(message = "L'ID dell'articolo di magazzino è richiesto")
    private Long articoloMagazzinoId;

    @NotNull(message = "L'ID del motore è richiesto")
    private Long motoreId;
}
