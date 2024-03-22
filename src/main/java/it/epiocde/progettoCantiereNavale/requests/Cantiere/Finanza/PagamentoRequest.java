package it.epiocde.progettoCantiereNavale.requests.Cantiere.Finanza;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class PagamentoRequest {
    @NotBlank(message = "Il metodo di pagamento è richiesto")
    private String metodoPagamento;

    @NotBlank(message = "Lo stato del pagamento è richiesto")
    private String statoPagamento;

    @NotNull(message = "La data del pagamento è richiesta")
    private Date dataPagamento;

    @NotNull(message = "L'importo pagato è richiesto")
    private Double importoPagato;

    // Aggiungi altri campi se necessario
}
