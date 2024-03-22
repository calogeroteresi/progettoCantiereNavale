package it.epiocde.progettoCantiereNavale.requests.Cantiere.Manutenzione;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MaterialeUtilizzatoManutenzioneRequest {
    @NotBlank(message = "Il nome del materiale è richiesto")
    private String nome;

    @NotNull(message = "La quantità utilizzata è richiesta")
    private double quantitaUtilizzata;

    @NotNull(message = "L'ID della manutenzione è richiesto")
    private Long maintenanceId;

    @NotNull(message = "L'ID dell'articolo di magazzino è richiesto")
    private Long articoloMagazzinoId;
}
