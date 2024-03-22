package it.epiocde.progettoCantiereNavale.requests.Ship;

import it.epiocde.progettoCantiereNavale.enums.Stato;
import it.epiocde.progettoCantiereNavale.enums.TipoBarca;
import it.epiocde.progettoCantiereNavale.enums.TipoCarburante;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Data
public class ShipRequest {
    @NotBlank(message = "La marca è richiesta")
    private String marca;

    @NotBlank(message = "Il modello è richiesto")
    private String modello;

    @NotNull(message = "L'anno è richiesto")
    private Integer anno;

    @NotNull(message = "Lo stato è richiesto")
    private Stato stato;

    @NotNull(message = "Il prezzo è richiesto")
    private Double prezzo;

    @NotNull(message = "Il tipo di barca è richiesto")
    private TipoBarca tipoBarca;

    private String classe;
    private Double lunghezzaMetri;
    private Double larghezzaMetri;
    private Double baglio;
    private Double pesoSecco;

    @NotNull(message = "Il tipo di carburante è richiesto")
    private TipoCarburante tipoCarburante;

    private String materialeScafo;
    private Integer bagni;
    private Integer postiLetto;
    private Integer pesoKg;
    private Integer capacitaPersone;
    private String propulsione;
    private String omologazione;

    private List<MotoreRequest> motori;
    private List<CaratteristicaRequest> caratteristiche;
    private Long dockId;
    private List<Long> maintenanceIds;
    private List<Long> certificateIds;
    private Long ownerId;
}
