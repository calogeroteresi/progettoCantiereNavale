package it.epiocde.progettoCantiereNavale.requests.Cantiere.Impiegati;

import lombok.Data;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

@Data
public class WorkScheduleRequest {
    @NotNull(message = "La data di lavoro è richiesta")
    private Date dataLavoro;

    private String attivita;

    private int oreLavorate;

    // Aggiungi altri campi se necessario

    @NotEmpty(message = "È richiesto almeno un dipendente")
    private Set<Long> dipendentiIds;

    @NotNull(message = "L'ID del lavoro è richiesto")
    private Long jobId;

    // Aggiungi altri campi se necessario
}
