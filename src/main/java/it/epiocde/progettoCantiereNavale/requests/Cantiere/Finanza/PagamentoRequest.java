package it.epiocde.progettoCantiereNavale.requests.Cantiere.Finanza;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.Date;

@Data
public class PagamentoRequest {
    @NotBlank(message = "Il metodo di pagamento è richiesto")
    private String metodoPagamento;

    @NotBlank(message = "Lo stato del pagamento è richiesto")
    private String statoPagamento;

    @NotNull(message = "La data del pagamento è richiesta")
    @PastOrPresent(message = "La data del pagamento deve essere nel passato o nel presente")
    private Date dataPagamento;

    @Positive(message = "L'importo pagato deve essere un numero positivo")
    @NotNull(message = "L'importo pagato è richiesto")
    private Double importoPagato;

}
