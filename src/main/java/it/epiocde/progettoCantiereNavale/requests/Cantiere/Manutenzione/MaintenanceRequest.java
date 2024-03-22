package it.epiocde.progettoCantiereNavale.requests.Cantiere.Manutenzione;

import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MaintenanceRequest {
    @NotBlank(message = "Il tipo di manutenzione è richiesto")
    private String tipo;

    @NotNull(message = "La data di inizio è richiesta")
    private Date dataInizio;

    @NotNull(message = "La data di fine è richiesta")
    private Date dataFine;

    @NotBlank(message = "La descrizione è richiesta")
    private String descrizione;

    @NotNull(message = "Il costo è richiesto")
    private Double costo;

    @NotNull(message = "L'ID della nave è richiesto")
    private Long shipId;

    @NotNull(message = "L'ID del report di incidente è richiesto")
    private Long incidentReportId;

    @NotNull(message = "È richiesta almeno un dipendente")
    private List<Long> employeeIds;

    // Aggiungi altri campi se necessario
}
