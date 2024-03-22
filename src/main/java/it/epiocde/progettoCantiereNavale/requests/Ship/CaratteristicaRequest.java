package it.epiocde.progettoCantiereNavale.requests.Ship;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CaratteristicaRequest {
    @NotNull(message = "L'ID della nave è richiesto")
    private Long shipId;

    private List<String> equipaggiamentiElettrici;

    private List<String> elettronici;

    private List<String> equipaggiamentiInterni;

    private List<String> dotazioniEsterne;

    private String certificazioneCE;

    private int cabine;

    private int doppioAncoraggio;

    private int cuccetteDoppie;

    private int cuccetteSingole;

    private int localeWCBagni;

    private int numeroMassimoPasseggeri;

    private int postiASedere;

    private String serbatoioAcqua;

    private String formaScafo;

    private String mulinello;

    private String garanziaScafo;

    // Aggiungi altri campi se necessario
}
