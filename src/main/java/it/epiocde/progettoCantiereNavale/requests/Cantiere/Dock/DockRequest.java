package it.epiocde.progettoCantiereNavale.requests.Cantiere.Dock;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DockRequest {
    @NotBlank(message = "La denominazione è richiesta")
    private String denominazione;

    @NotNull(message = "La latitudine è richiesta")
    private Double latitudine;

    @NotNull(message = "La longitudine è richiesta")
    private Double longitudine;

    @NotBlank(message = "L'indirizzo completo è richiesto")
    private String indirizzoCompleto;

    @NotBlank(message = "La provincia è richiesta")
    private String provincia;

    @NotBlank(message = "Il comune è richiesto")
    private String comune;

    @NotNull(message = "La capacità massima è richiesta")
    private Integer capacitaMassima;

    // Aggiungi altri campi se necessario
}
