package it.epiocde.progettoCantiereNavale.entities.Ship;

import it.epiocde.progettoCantiereNavale.entities.Cantiere.Dock.Dock;
import it.epiocde.progettoCantiereNavale.entities.Cantiere.Manutenzione.Maintenance;
import it.epiocde.progettoCantiereNavale.entities.User.Customer;
import it.epiocde.progettoCantiereNavale.enums.Stato;
import it.epiocde.progettoCantiereNavale.enums.TipoBarca;
import it.epiocde.progettoCantiereNavale.enums.TipoCarburante;
import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modello;
    private int anno;

    @Enumerated(EnumType.STRING)
    @Column(name = "stato")
    private Stato stato;

    private double prezzo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_barca")
    private TipoBarca tipoBarca;

    private String classe;
    private double lunghezzaMetri;
    private double larghezzaMetri;
    private double baglio;
    private double pesoSecco;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_carburante")
    private TipoCarburante tipoCarburante;

    private String materialeScafo;
    private int bagni;
    private int postiLetto;
    private int pesoKg;
    private int capacitaPersone;
    private String propulsione;
    private String omologazione;

    @OneToMany(mappedBy = "ship", cascade = CascadeType.ALL)
    private List<Motore> motori;

    @OneToMany(mappedBy = "ship", cascade = CascadeType.ALL)
    private List<Caratteristica> caratteristiche;

    @ManyToOne
    @JoinColumn(name = "dock_id")
    private Dock dock;

    @OneToMany(mappedBy = "ship", cascade = CascadeType.ALL)
    private List<Maintenance> maintenances;


    @OneToMany(mappedBy = "ship", cascade = CascadeType.ALL)
    private List<Certificate> certificates;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer owner;
}
