package it.epiocde.progettoCantiereNavale.entities.Ship;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String descrizione;
    private String numero;
    private String enteRilascio;

    @ManyToOne
    @JoinColumn(name = "ship_id")
    private Ship ship;
}
