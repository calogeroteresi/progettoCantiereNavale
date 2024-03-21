package it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza;

import it.epiocde.progettoCantiereNavale.enums.StatoFattura;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "fatture")
public class Fattura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroFattura;
    private Date dataEmissione;
    private Double importoTotale;
    @Enumerated(EnumType.STRING)
    private StatoFattura stato;

}
