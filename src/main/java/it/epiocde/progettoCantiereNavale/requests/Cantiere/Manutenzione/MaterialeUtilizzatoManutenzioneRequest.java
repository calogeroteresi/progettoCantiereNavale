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

    private Long maintenanceId;

    private Long articoloMagazzinoId;
}
