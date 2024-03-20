package it.epiocde.progettoCantiereNavale.entities.Ship;

import it.epiocde.progettoCantiereNavale.enums.TipoMotore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Motore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_motore")
    private TipoMotore tipoMotore;

    private String marca;
    private String modello;

    @Column(name = "tipo_carburante")
    private String tipoCarburante;
    private int anno;

    @Column(name = "potenza_hp")
    private int potenzaHp;

    @Column(name = "tipo_trasmissione")
    private String tipoTrasmissione;

    @Column(name = "ore_motore")
    private int oreMotore;

    @ManyToOne
    @JoinColumn(name = "id_ship", referencedColumnName = "id")
    private Ship ship;
}
