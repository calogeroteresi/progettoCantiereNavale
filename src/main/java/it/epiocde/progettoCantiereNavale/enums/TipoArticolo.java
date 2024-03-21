package it.epiocde.progettoCantiereNavale.enums;

import lombok.Getter;

@Getter
public enum TipoArticolo {
    MATERIALE("Materiale"),
    STRUMENTO("Strumento"),
    COMPONENTE("Componente"),
    MOTORE("Motore"),
    ALTRO("Altro");

    private final String descrizione;

    TipoArticolo(String descrizione) {
        this.descrizione = descrizione;
    }

}
