package it.epiocde.progettoCantiereNavale.requests.Cantiere.Clienti;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerFeedbackRequest {
    @NotBlank(message = "Il commento è richiesto")
    private String commento;


    @NotNull(message = "La valutazione è obbligatoria")
    @Min(value = 1, message = "La valutazione minima è 1")
    @Max(value = 5, message = "La valutazione massima è 5")
    private Integer valutazione;

    private Long customerId;
    private Long serviceOfferingId;

    }


