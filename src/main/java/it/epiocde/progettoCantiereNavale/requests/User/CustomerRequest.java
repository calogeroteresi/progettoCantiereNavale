package it.epiocde.progettoCantiereNavale.requests.User;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerRequest extends UserRequest {
    @NotBlank(message = "L'indirizzo è richiesto")
    private String indirizzo;

    @Pattern(regexp = "\\d{10}", message = "Il numero di telefono deve essere composto da 10 cifre")
    private String numeroTelefono;

    @NotNull(message = "Il tipo cliente è richiesto")
    private String tipoCliente;

    private List<Long> customerFeedbackIds;
    private List<Long> orderIds;
    private List<Long> reservationIds;
    private List<Long> reviewIds;
    private List<Long> fatturaClienteIds;
    private List<Long> shipIds;
}
