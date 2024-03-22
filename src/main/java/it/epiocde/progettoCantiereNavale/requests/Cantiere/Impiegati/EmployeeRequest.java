package it.epiocde.progettoCantiereNavale.requests.Cantiere.Impiegati;

import it.epiocde.progettoCantiereNavale.enums.RuoloImpiegato;
import it.epiocde.progettoCantiereNavale.enums.SettoreImpiegato;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import jakarta.validation.constraints.Positive;
import java.util.Date;

@Data
public class EmployeeRequest {
    @NotBlank(message = "Il nome è richiesto")
    private String nome;

    @NotBlank(message = "Il cognome è richiesto")
    private String cognome;

    @NotNull(message = "Il ruolo è richiesto")
    private RuoloImpiegato ruolo;

    @NotNull(message = "Il settore è richiesto")
    private SettoreImpiegato settore;

    @NotNull(message = "La data di assunzione è richiesta")
    private Date dataAssunzione;

    @Positive(message = "Lo stipendio deve essere un valore positivo")
    @NotNull(message = "Lo stipendio è richiesto")
    private double stipendio;

}
