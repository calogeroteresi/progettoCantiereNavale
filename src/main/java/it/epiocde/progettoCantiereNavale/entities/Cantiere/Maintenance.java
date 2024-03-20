package it.epiocde.progettoCantiereNavale.entities.Cantiere;

import javax.persistence.*;
import java.util.Date;
import lombok.Data;

@Data
@Entity
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    @Temporal(TemporalType.DATE)
    private Date dataInizio;
    @Temporal(TemporalType.DATE)
    private Date dataFine;
    private String descrizione;
    private double costo;

}
