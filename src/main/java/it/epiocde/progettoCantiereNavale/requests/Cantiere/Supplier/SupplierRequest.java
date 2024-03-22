package it.epiocde.progettoCantiereNavale.requests.Cantiere.Supplier;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SupplierRequest {
    @NotBlank(message = "Il nome del fornitore è richiesto")
    private String nome;

    @NotBlank(message = "Le informazioni di contatto sono richieste")
    private String informazioniContatto;

    @NotBlank(message = "Il tipo di prodotti forniti è richiesto")
    private String tipoProdottiForniti;

    // Aggiungi altri campi se necessario

    // Puoi aggiungere anche una lista di RicevutaRequest e FatturaFornitoreRequest
    // se vuoi gestire l'inserimento di ricevute e fatture insieme al fornitore
}
