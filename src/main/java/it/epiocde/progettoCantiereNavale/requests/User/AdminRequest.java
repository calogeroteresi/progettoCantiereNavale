package it.epiocde.progettoCantiereNavale.requests.User;

import it.epiocde.progettoCantiereNavale.enums.RuoloAdmin;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class AdminRequest extends UserRequest {
    @NotNull(message = "Il ruolo admin è richiesto")
    private RuoloAdmin ruoloAdmin;
    private Long adminEmployeeId;
    private List<Long> employeeIds;
}
