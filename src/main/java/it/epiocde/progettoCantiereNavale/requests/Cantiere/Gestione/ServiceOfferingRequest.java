package it.epiocde.progettoCantiereNavale.requests.Cantiere.Gestione;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ServiceOfferingRequest {
    @NotBlank(message = "Il nome del servizio è richiesto")
    private String serviceName;

    @NotBlank(message = "La descrizione del servizio è richiesta")
    private String description;

    @NotNull(message = "Il prezzo è richiesto")
    private Double price;

    // Aggiungi altri campi se necessario
}
