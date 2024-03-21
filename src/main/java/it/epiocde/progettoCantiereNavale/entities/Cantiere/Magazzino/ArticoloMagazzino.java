package it.epiocde.progettoCantiereNavale.entities.Cantiere.Magazzino;

import javax.persistence.*;

import it.epiocde.progettoCantiereNavale.enums.TipoArticolo;
import lombok.Data;

@Data
@Entity
public class ArticoloMagazzino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codice;
    private String descrizione;
    private double prezzoUnitario;
    private int quantitaDisponibile;

    @ManyToOne
    @JoinColumn(name = "magazzino_id")
    private Magazzino magazzino;

    @Enumerated(EnumType.STRING)
    private TipoArticolo tipo;
}
