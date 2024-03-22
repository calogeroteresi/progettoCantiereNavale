package it.epiocde.progettoCantiereNavale.requests.User;

import it.epiocde.progettoCantiereNavale.enums.RuoloAdmin;
import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.validation.constraints.NotNull;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class AdminRequest extends UserRequest {
    @NotNull(message = "Il ruolo admin è richiesto")
    private RuoloAdmin ruoloAdmin;

    @NotNull(message = "L'ID dell'AdminEmployee è richiesto")
    private Long adminEmployeeId;

    @NotNull(message = "Almeno un ID di Employee è richiesto")
    private List<Long> employeeIds;
}
