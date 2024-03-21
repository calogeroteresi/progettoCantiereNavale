package it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati;

import it.epiocde.progettoCantiereNavale.entities.User.Admin;
import it.epiocde.progettoCantiereNavale.enums.RuoloImpiegato;
import it.epiocde.progettoCantiereNavale.enums.SettoreImpiegato;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cognome;
    @Enumerated(EnumType.STRING)
    @Column(name = "ruolo_impiegato")
    private RuoloImpiegato ruolo;
    @Enumerated(EnumType.STRING)
    @Column(name = "settore_impiegato")
    private SettoreImpiegato settore;
    @Temporal(TemporalType.DATE)
    private Date dataAssunzione;
    private double stipendio;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToMany(mappedBy = "dipendenti")
    private Set<SchedaLavoroDipendenti> schedeLavoro = new HashSet<>();
}
