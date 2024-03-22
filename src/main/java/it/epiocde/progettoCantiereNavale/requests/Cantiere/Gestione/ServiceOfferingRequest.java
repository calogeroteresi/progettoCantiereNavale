package it.epiocde.progettoCantiereNavale.requests.Cantiere.Gestione;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ServiceOfferingRequest {
    @NotBlank(message = "Il nome del servizio è richiesto")
    private String serviceName;

    @NotBlank(message = "La descrizione del servizio è richiesta")
    private String description;

    private Double price;

    // Aggiungi altri campi se necessario
}
