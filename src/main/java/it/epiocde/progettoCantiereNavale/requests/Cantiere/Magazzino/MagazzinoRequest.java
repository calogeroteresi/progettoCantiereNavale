package it.epiocde.progettoCantiereNavale.requests.Cantiere.Magazzino;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MagazzinoRequest {
    @NotBlank(message = "Il nome del magazzino è richiesto")
    private String nome;

    @NotBlank(message = "L'ubicazione del magazzino è richiesta")
    private String ubicazione;

    @NotBlank(message = "La descrizione del magazzino è richiesta")
    private String descrizione;

    // Aggiungi qui altri campi se necessario
}
