package it.epiocde.progettoCantiereNavale.enums;

import lombok.Getter;

@Getter
public enum RuoloAdmin {
    AMMINISTRATORE("Amministratore", QualificaAdmin.ALTO),
    GESTORE_MAGAZZINO("Gestore Magazzino", QualificaAdmin.MEDIO),
    RESPONSABILE_CUSTOMER("Responsabile Clienti", QualificaAdmin.MEDIO),
    RESPONSABILE_DOCK("Responsabile Dock", QualificaAdmin.MEDIO),
    SUPERVISORE_MANUTENZIONE("Supervisore Manutenzione", QualificaAdmin.BASSO);


    private final String descrizione;
    private final QualificaAdmin qualifica;

    RuoloAdmin(String descrizione, QualificaAdmin qualifica) {
        this.descrizione = descrizione;
        this.qualifica = qualifica;
    }
}
