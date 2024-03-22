package it.epiocde.progettoCantiereNavale.requests.Cantiere.Clienti;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.util.Date;
import java.util.List;

@Data
public class OrderCustomerRequest {
    @NotNull(message = "La data dell'ordine è richiesta")
    private Date dataOrdine;

    private double importoTotale;

    private Long customerId;

    private List<Long> serviceOfferingIds;

}
