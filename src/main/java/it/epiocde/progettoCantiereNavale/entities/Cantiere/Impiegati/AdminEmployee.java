package it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati;

import it.epiocde.progettoCantiereNavale.entities.User.Admin;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class AdminEmployee extends Employee{

    @OneToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
}
