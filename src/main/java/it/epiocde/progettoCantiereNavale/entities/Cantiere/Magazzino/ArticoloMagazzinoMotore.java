package it.epiocde.progettoCantiereNavale.entities.Cantiere.Magazzino;

import it.epiocde.progettoCantiereNavale.entities.Ship.Motore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "articoli_magazzino_motori")
public class ArticoloMagazzinoMotore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_articolo_magazzino")
    private ArticoloMagazzino articoloMagazzino;

    @ManyToOne
    @JoinColumn(name = "id_motore")
    private Motore motore;
}
