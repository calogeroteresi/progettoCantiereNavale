package it.epiocde.progettoCantiereNavale.requests.Cantiere.Clienti;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerFeedbackRequest {
    @NotBlank(message = "Il commento è richiesto")
    private String commento;

    private int valutazione;

}
