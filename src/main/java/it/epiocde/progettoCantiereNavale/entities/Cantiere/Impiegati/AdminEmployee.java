package it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati;

import it.epiocde.progettoCantiereNavale.entities.User.Admin;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name="admin_employee")
public class AdminEmployee extends Employee{

    @OneToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
}
