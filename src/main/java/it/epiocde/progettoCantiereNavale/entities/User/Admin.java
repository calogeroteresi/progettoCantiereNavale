package it.epiocde.progettoCantiereNavale.entities.User;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati.AdminEmployee;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati.Employee;

import it.epiocde.progettoCantiereNavale.enums.RuoloAdmin;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Admin extends User{
    @OneToOne(mappedBy = "admin")
    private AdminEmployee adminEmployee;
    @OneToMany(mappedBy = "admin")
    private List<Employee> employees;
    private RuoloAdmin ruoloAdmin;

}
