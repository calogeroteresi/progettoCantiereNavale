package it.epiocde.progettoCantiereNavale.entities.Cantiere.Dock;


import it.epiocde.progettoCantiereNavale.entities.Ship.Ship;
import it.epiocde.progettoCantiereNavale.enums.StatoDock;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "docks")
public class Dock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String denominazione;
    private double latitudine;
    private double longitudine;

    @Column(name = "indirizzo_completo")
    private String indirizzoCompleto;

    private String provincia;
    private String comune;

    @Column(name = "capacita_massima")
    private int capacitaMassima;

    @Enumerated(EnumType.STRING)
    private StatoDock stato;

    @OneToMany(mappedBy = "dock")
    private List<Ship> ships;
}
