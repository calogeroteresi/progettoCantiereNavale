package it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati;

import it.epiocde.progettoCantiereNavale.entities.User.Admin;
import jakarta.persistence.*;

import java.util.Date;

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cognome;
    private String ruolo;
    private String reparto;
    @Temporal(TemporalType.DATE)
    private Date dataAssunzione;
    private double stipendio;

    @OneToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

}
