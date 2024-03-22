package it.epiocde.progettoCantiereNavale.requests.Ship;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CertificateRequest {
    @NotNull(message = "L'ID della nave è richiesto")
    private Long shipId;

    @NotBlank(message = "Il tipo di certificato è richiesto")
    private String tipo;

    @NotBlank(message = "La descrizione del certificato è richiesta")
    private String descrizione;

    @NotBlank(message = "Il numero del certificato è richiesto")
    private String numero;

    @NotBlank(message = "L'ente di rilascio del certificato è richiesto")
    private String enteRilascio;

    // Aggiungi altri campi se necessario
}
