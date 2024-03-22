package it.epiocde.progettoCantiereNavale.requests.Cantiere.Magazzino;

import lombok.Data;

@Data
public class MagazzinoRequest {
    private String nome;
    private String ubicazione;
    private String descrizione;

    // Aggiungi qui altri campi se necessario
}
