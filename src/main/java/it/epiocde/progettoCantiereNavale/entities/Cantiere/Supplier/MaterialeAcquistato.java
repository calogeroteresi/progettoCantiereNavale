package it.epiocde.progettoCantiereNavale.entities.Cantiere.Supplier;

import it.epiocde.progettoCantiereNavale.enums.TipoArticolo;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "materiale_acquistato")
public class MaterialeAcquistato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int quantita;
    private double prezzoUnitario;
    @Enumerated(EnumType.STRING)
    private TipoArticolo tipo;

}
