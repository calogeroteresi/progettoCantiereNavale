package it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(name = "schede_lavoro_dipendenti")
public class SchedaLavoroDipendenti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dataLavoro;

    private String attivita;

    private int oreLavorate;

    @ManyToMany
    @JoinTable(
            name = "dipendenti_schede_lavoro",
            joinColumns = @JoinColumn(name = "scheda_lavoro_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Set<Employee> dipendenti = new HashSet<>();

}
