package it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza;


import it.epiocde.progettoCantiereNavale.entities.Cantiere.Supplier.Ricevuta;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Supplier.Supplier;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza.Pagamento;
import it.epiocde.progettoCantiereNavale.enums.StatoFattura;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "fatture_fornitori")
public class FatturaFornitore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroFattura;
    private Date dataEmissione;
    private Double importoTotale;
    @Enumerated(EnumType.STRING)
    private StatoFattura stato;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToMany(mappedBy = "fatturaFornitore", cascade = CascadeType.ALL)
    private List<Ricevuta> ricevute = new ArrayList<>();

    @OneToMany(mappedBy = "fatturaFornitore")
    private List<Pagamento> pagamenti;
}
