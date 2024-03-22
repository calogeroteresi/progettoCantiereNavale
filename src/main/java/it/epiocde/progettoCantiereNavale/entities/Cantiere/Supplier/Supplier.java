package it.epiocde.progettoCantiereNavale.entities.Cantiere.Supplier;

import jakarta.persistence.*;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza.FatturaFornitore;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String informazioniContatto;
    private String tipoProdottiForniti;

    @OneToMany(mappedBy = "supplier")
    private List<Ricevuta> ricevute;

    @OneToMany(mappedBy = "supplier")
    private List<FatturaFornitore> fattureFornitore;
}
