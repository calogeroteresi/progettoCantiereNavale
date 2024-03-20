package it.epiocde.progettoCantiereNavale.entities.User;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati.Employee;
import jakarta.persistence.OneToOne;

public class Admin extends User{
    @OneToOne(mappedBy = "admin")
    private Employee employee;
}
