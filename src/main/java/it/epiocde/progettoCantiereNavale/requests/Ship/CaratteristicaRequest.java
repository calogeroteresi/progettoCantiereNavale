package it.epiocde.progettoCantiereNavale.requests.Ship;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CaratteristicaRequest {
    @NotNull(message = "L'ID della nave è richiesto")
    private Long shipId;

    // Lista di equipaggiamenti elettrici
    private List<@NotBlank(message = "L'equipaggiamento elettrico non può essere vuoto") String> equipaggiamentiElettrici;

    // Lista di componenti elettronici
    private List<@NotBlank(message = "Il componente elettronico non può essere vuoto") String> elettronici;

    // Lista di equipaggiamenti interni
    private List<@NotBlank(message = "L'equipaggiamento interno non può essere vuoto") String> equipaggiamentiInterni;

    // Lista di dotazioni esterne
    private List<@NotBlank(message = "La dotazione esterna non può essere vuota") String> dotazioniEsterne;

    // Certificazione CE
    private String certificazioneCE;

    // Numero di cabine
    private int cabine;

    // Numero di ancoraggi doppi
    private int doppioAncoraggio;

    // Numero di cuccette doppie
    private int cuccetteDoppie;

    // Numero di cuccette singole
    private int cuccetteSingole;

    // Numero di locali WC/bagni
    private int localeWCBagni;

    // Numero massimo di passeggeri
    private int numeroMassimoPasseggeri;

    // Numero di posti a sedere
    private int postiASedere;

    // Capacità del serbatoio acqua
    private String serbatoioAcqua;

    // Forma dello scafo
    private String formaScafo;

    // Specifiche del mulinello
    private String mulinello;

    // Garanzia dello scafo
    private String garanziaScafo;

}
