package it.epiocde.progettoCantiereNavale.requests.Cantiere.Clienti;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.util.Date;
import java.util.List;

@Data
public class OrderCustomerRequest {
    @NotNull(message = "La data dell'ordine è richiesta")
    private Date dataOrdine;

    @NotNull(message = "L'importo totale è richiesto")
    private Double importoTotale;

    @NotNull(message = "L'ID del cliente è richiesto")
    private Long customerId;

    @NotEmpty(message = "Almeno un ID dell'offerta di servizio è richiesto")
    private List<Long> serviceOfferingIds;
}

