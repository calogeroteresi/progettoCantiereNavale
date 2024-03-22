package it.epiocde.progettoCantiereNavale.requests.Cantiere.Supplier;

import it.epiocde.progettoCantiereNavale.enums.TipoArticolo;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DettaglioAcquistoRequest {
    private Long ricevutaId;

    @NotBlank(message = "Il nome del materiale è richiesto")
    private String nomeMateriale;

    private int quantita;

    private double prezzoUnitario;

    private TipoArticolo tipo;
}
