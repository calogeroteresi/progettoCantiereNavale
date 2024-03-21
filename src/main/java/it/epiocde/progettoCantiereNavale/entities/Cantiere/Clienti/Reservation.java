package it.epiocde.progettoCantiereNavale.entities.Cantiere.Clienti;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataPrenotazione;
    private Date dataInizio;
    private Date dataFine;
    private boolean confermata;

}
