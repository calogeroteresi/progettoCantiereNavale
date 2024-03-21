package it.epiocde.progettoCantiereNavale.entities.Cantiere.Magazzino;

import javax.persistence.*;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Finanza.FatturaFornitore;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Manutenzione.MaterialeUtilizzatoManutenzione;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Supplier.Ricevuta;
import it.epiocde.progettoCantiereNavale.entities.Ship.Motore;
import it.epiocde.progettoCantiereNavale.enums.TipoArticolo;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "articoli_magazzino") // Cambio il nome della tabella per distinguere gli articoli di magazzino dai dettagli di acquisto
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

    @ManyToOne
    @JoinColumn(name = "fattura_id")
    private FatturaFornitore fatturaFornitore;

    @OneToMany(mappedBy = "articoloMagazzino")
    private List<MaterialeUtilizzatoManutenzione> materialiUtilizzati;



}
