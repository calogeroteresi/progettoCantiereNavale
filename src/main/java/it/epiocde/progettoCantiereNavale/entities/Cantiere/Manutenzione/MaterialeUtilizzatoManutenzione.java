package it.epiocde.progettoCantiereNavale.entities.Cantiere.Manutenzione;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Magazzino.ArticoloMagazzino;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class MaterialeUtilizzatoManutenzione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private double quantitaUtilizzata;

    @ManyToOne
    @JoinColumn(name = "maintenance_id")
    private Maintenance maintenance;

    @ManyToOne
    @JoinColumn(name = "articolo_magazzino_id")
    private ArticoloMagazzino articoloMagazzino;

}
