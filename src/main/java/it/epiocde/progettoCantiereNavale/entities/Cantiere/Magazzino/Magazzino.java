package it.epiocde.progettoCantiereNavale.entities.Cantiere.Magazzino;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Magazzino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String ubicazione;
    private String descrizione;

    @OneToMany(mappedBy = "magazzino")
    private List<ArticoloMagazzino> articoliMagazzino;
}
