package it.epiocde.progettoCantiereNavale.entities.Cantiere.Supplier;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza.FatturaFornitore;
import it.epiocde.progettoCantiereNavale.enums.TipoArticolo;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "ricevute")
public class Ricevuta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataRicevuta;
    private String numeroRicevuta;
    private double importoTotale;

    @OneToMany(mappedBy = "ricevuta", cascade = CascadeType.ALL)
    private List<DettaglioAcquisto> dettagliAcquisti = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "fattura_fornitore_id")
    private FatturaFornitore fatturaFornitore;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
