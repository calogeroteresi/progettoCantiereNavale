package it.epiocde.progettoCantiereNavale.entities.Cantiere.Impiegati;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titolo;
    private String descrizione;
    @Temporal(TemporalType.DATE)
    private Date dataInizio;
    @Temporal(TemporalType.DATE)
    private Date dataFine;
    private String stato;
}
