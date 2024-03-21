package it.epiocde.progettoCantiereNavale.entities.Cantiere.Manutenzione;

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

}
