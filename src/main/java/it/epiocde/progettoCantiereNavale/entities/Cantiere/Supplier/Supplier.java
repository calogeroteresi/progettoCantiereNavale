package it.epiocde.progettoCantiereNavale.entities.Cantiere.Supplier;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String informazioniContatto;
    private String tipoProdottiForniti;


}
