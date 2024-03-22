package it.epiocde.progettoCantiereNavale.requests.Ship;

import it.epiocde.progettoCantiereNavale.enums.TipoMotore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MotoreRequest {
    @NotNull(message = "L'ID della nave è richiesto")
    private Long shipId;

    @NotNull(message = "Il tipo di motore è richiesto")
    private TipoMotore tipoMotore;

    @NotBlank(message = "La marca del motore è richiesta")
    private String marca;

    @NotBlank(message = "Il modello del motore è richiesto")
    private String modello;

    @NotBlank(message = "Il tipo di carburante è richiesto")
    private String tipoCarburante;

    @NotNull(message = "L'anno di produzione del motore è richiesto")
    private Integer anno;

    @NotNull(message = "La potenza del motore in cavalli è richiesta")
    private Integer potenzaHp;

    @NotBlank(message = "Il tipo di trasmissione è richiesto")
    private String tipoTrasmissione;

    @NotNull(message = "Le ore di utilizzo del motore sono richieste")
    private Integer oreMotore;

    // Aggiungi altri campi se necessario
}
