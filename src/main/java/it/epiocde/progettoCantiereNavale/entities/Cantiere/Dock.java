package it.epiocde.progettoCantiereNavale.entities.Cantiere;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Dock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;
    private int capacita;
    private boolean disponibilita;
    private String stato;

}
