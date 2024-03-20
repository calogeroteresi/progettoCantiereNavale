package it.epiocde.progettoCantiereNavale.entities.Cantiere;

import javax.persistence.*;
import java.util.Date;
import lombok.Data;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dataOrdine;
    private String articoliOrdinati;
    private double importoTotale;
    private String statoOrdine;


}
